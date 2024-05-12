import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javalib.impworld.World;
import javalib.impworld.WorldScene;
import javalib.worldimages.OutlineMode;
import javalib.worldimages.OverlayImage;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.RotateImage;
import javalib.worldimages.StarImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;
import tester.Tester;



//game state and main game class
class LightEmAll extends World {

  ArrayList<ArrayList<GamePiece>> board;
  ArrayList<GamePiece> nodes;
  ArrayList<Edge> mst;
  int width; 
  int height; 
  int powerRow; 
  int powerCol; 
  int radius; 
  Random rand; 
  int score;
  int gameEnd;
  int time; 
  public static int CELL_SIZE = 40; 

  int maxScore = 20; 
  int maxTime = 240; 

  // the default gameplay constructor
  LightEmAll(int width, int height) {
    this(width, height, 3);
  }

  // constructor for making different types of boards
  LightEmAll(int width, int height, int genType) {
    this(width, height, genType, new Random());
  }

  // constructor for generating different types of boards but you pass in a random
  LightEmAll(int width, int height, int genType, Random rand) {
    if (genType == -1) { 
      this.rand = rand;
      this.width = width;
      this.height = height;
      this.powerRow = 0;
      this.powerCol = 0;
      this.board = this.spawnBoard();
      this.nodes = this.acquireNodes();
      this.mst = generateMST(genAllValidEdges(this.board));
      this.score = 0;
      this.radius = (this.calcDiameter() / 2) + 1;
      this.gameEnd = 0;
      this.time = 0;
    }
    else if (genType == 1) { 
      this.rand = rand;
      this.width = width;
      this.height = height;
      this.powerRow = 0;
      this.powerCol = 0;
      this.board = this.spawnBoard();
      this.nodes = this.acquireNodes();
      this.mst = generateMST(genAllValidEdges(this.board));
      this.score = 0;
      generateManualConnections();
      updateAllNeighbors();
      this.radius = (this.calcDiameter() / 2) + 1;
      updatePower(this.board);
      this.gameEnd = 0;
      this.time = 0;
    }
    else if (genType == 2) { 
      this.rand = rand;
      this.width = width;
      this.height = height;
      this.powerRow = 0;
      this.powerCol = 0;
      this.board = this.spawnBoard();
      this.nodes = this.acquireNodes();
      this.mst = generateMST(genAllValidEdges(this.board));
      this.score = 0;
      generatePartialConnections(new Posn(0, 0), this.board);
      updateAllNeighbors();
      this.radius = (this.calcDiameter() / 2) + 1;
      updatePower(this.board);
      this.gameEnd = 0;
      this.time = 0;
    }

    else if (genType == 3) { 
      this.rand = rand;
      this.width = width;
      this.height = height;
      this.powerRow = 0;
      this.powerCol = 0;
      this.board = this.spawnBoard();
      this.nodes = this.acquireNodes();
      this.mst = generateMST(genAllValidEdges(this.board));
      this.score = 0;
      this.radius = (this.calcDiameter() / 2) + 1;
      newEdgeLink();
      updateAllNeighbors();
      this.radius = (this.calcDiameter() / 2) + 1;
      randomizeGrid(this.nodes);
      updatePower(this.board);
      this.gameEnd = 0;
      this.time = 0;
    }
  }


  // will grab all the boards cells, left to right, then top to bottom
  public ArrayList<GamePiece> acquireNodes() {
    ArrayList<GamePiece> allNodes = new ArrayList<GamePiece>();
    for (int c = 0; c < this.width; c++) {
      for (int r = 0; r < this.height; r++) {
        allNodes.add(this.board.get(c).get(r));
      }
    }
    return allNodes;
  }

  // creates manual connections
  public void generateManualConnections() {
    int middleColIndex = (int) Math.floor(this.width / 2);
    for (int c = 0; c < this.width; c++) {
      for (int r = 0; r < this.height; r++) {
        if (c == 0) {
          this.board.get(c).get(r).left = false;
          this.board.get(c).get(r).right = true;
          this.board.get(c).get(r).top = false;
          this.board.get(c).get(r).bottom = false;
        }
        else if (c == middleColIndex) { 
          this.board.get(c).get(r).left = true;
          this.board.get(c).get(r).right = true;
          this.board.get(c).get(r).top = true;
          this.board.get(c).get(r).bottom = true;
        }
        else if ((c + 1) == this.width) { 
          this.board.get(c).get(r).left = true;
          this.board.get(c).get(r).right = false;
          this.board.get(c).get(r).top = false;
          this.board.get(c).get(r).bottom = false;
        }
        else { // all other columns
          this.board.get(c).get(r).left = true;
          this.board.get(c).get(r).right = true;
          this.board.get(c).get(r).top = false;
          this.board.get(c).get(r).bottom = false;
        }
      }
    }
  }

  // generates a fractal board
  public void generatePartialConnections(Posn lastKnownPosition,
      ArrayList<ArrayList<GamePiece>> currentBoard) {
    ArrayList<ArrayList<ArrayList<GamePiece>>> splits = 
        new ArrayList<ArrayList<ArrayList<GamePiece>>>();
    int splitType = determineSplitType(currentBoard);
    if (splitType == 0) { 
      int colCount = currentBoard.size();
      int rowCount = currentBoard.get(0).size();
      if (colCount == 2 && rowCount == 2) {
        buildU(currentBoard);
      }
      if (colCount == 2 && rowCount == 3) { 
        buildU(currentBoard);
      }
      if (colCount == 3 && rowCount == 2) { 
        buildU(currentBoard);
        currentBoard.get(1).get(0).bottom = true;
        currentBoard.get(1).get(1).top = true;
      }
      if (colCount == 3 && rowCount == 3) { 
        buildU(currentBoard);
        currentBoard.get(1).get(0).bottom = true;
        currentBoard.get(1).get(1).top = true;
        currentBoard.get(1).get(1).bottom = true;
        currentBoard.get(1).get(2).top = true;
      }
    }
    else if (splitType == 1) {
      buildU(currentBoard);
      splits = splitBoard(splitType, currentBoard);
      generatePartialConnections(new Posn(0, 0), splits.get(0));
      generatePartialConnections(new Posn(1, 0), splits.get(1));
      generatePartialConnections(new Posn(0, 1), splits.get(2));
      generatePartialConnections(new Posn(0, 1), splits.get(3));
    }
    else if (splitType == 2) { 
      splits = splitBoard(splitType, currentBoard); 
      int bottomRow = splits.get(0).get(0).size() - 1;
      int rightCol = splits.get(0).size() - 1;
      if (lastKnownPosition.x == 0) { 

        splits.get(0).get(0).get(bottomRow).bottom = true;
        splits.get(1).get(0).get(0).top = true; 
      }
      if (lastKnownPosition.x == 1) { 
        splits.get(0).get(rightCol).get(bottomRow).bottom = true; 
        splits.get(1).get(rightCol).get(0).top = true; 
      }
      generatePartialConnections(new Posn(0, 0), splits.get(0));
      generatePartialConnections(new Posn(0, 1), splits.get(1));
    }
    else if (splitType == 3) { 
      buildU(currentBoard);
      splits = splitBoard(splitType, currentBoard); 
      generatePartialConnections(new Posn(0, 0), splits.get(0));
      generatePartialConnections(new Posn(1, 0), splits.get(1));
    }
  }

  // splits the board in the desired manner
  public ArrayList<ArrayList<ArrayList<GamePiece>>> splitBoard(int splitType,
      ArrayList<ArrayList<GamePiece>> boardToSplit) {
    ArrayList<ArrayList<ArrayList<GamePiece>>> ret = 
        new ArrayList<ArrayList<ArrayList<GamePiece>>>();

    int splitCol = boardToSplit.size() / 2 + ((boardToSplit.size() % 2 == 0) ? 0 : 1);
    int splitRow = boardToSplit.get(0).size() / 2 + ((boardToSplit.get(0).size() % 2 == 0) ? 0 : 1);
    if (splitType == 1) { 
      ArrayList<ArrayList<GamePiece>> quad1 = new ArrayList<ArrayList<GamePiece>>();
      ArrayList<ArrayList<GamePiece>> quad2 = new ArrayList<ArrayList<GamePiece>>();
      ArrayList<ArrayList<GamePiece>> quad3 = new ArrayList<ArrayList<GamePiece>>();
      ArrayList<ArrayList<GamePiece>> quad4 = new ArrayList<ArrayList<GamePiece>>();
      for (int c = 0; c < splitCol; c++) {
        quad1.add(new ArrayList<GamePiece>(boardToSplit.get(c).subList(0, splitRow)));
        quad3.add(new ArrayList<GamePiece>(
            boardToSplit.get(c).subList(splitRow, boardToSplit.get(0).size())));
      }
      for (int c = splitCol; c < boardToSplit.size(); c++) {
        quad2.add(new ArrayList<GamePiece>(boardToSplit.get(c).subList(0, splitRow)));
        quad4.add(new ArrayList<GamePiece>(
            boardToSplit.get(c).subList(splitRow, boardToSplit.get(0).size())));
      }
      ret.add(quad1);
      ret.add(quad2);
      ret.add(quad3);
      ret.add(quad4);
    }
    if (splitType == 2) { 
      ArrayList<ArrayList<GamePiece>> top = new ArrayList<ArrayList<GamePiece>>();
      ArrayList<ArrayList<GamePiece>> bottom = new ArrayList<ArrayList<GamePiece>>();
      for (int c = 0; c < boardToSplit.size(); c++) {
        top.add(new ArrayList<GamePiece>(boardToSplit.get(c).subList(0, splitRow)));
        bottom.add(new ArrayList<GamePiece>(
            boardToSplit.get(c).subList(splitRow, boardToSplit.get(0).size())));
      }
      ret.add(top);
      ret.add(bottom);
    }
    if (splitType == 3) { 
      ArrayList<ArrayList<GamePiece>> left = new ArrayList<ArrayList<GamePiece>>(
          boardToSplit.subList(0, splitCol));
      ArrayList<ArrayList<GamePiece>> right = new ArrayList<ArrayList<GamePiece>>(
          boardToSplit.subList(splitCol, boardToSplit.size()));
      ret.add(left);
      ret.add(right);
    }
    return ret;
  }

  public int determineSplitType(ArrayList<ArrayList<GamePiece>> currentBoard) {
    int colCount = currentBoard.size();
    int rowCount = currentBoard.get(0).size();
    if (colCount < 4 && rowCount < 4) { 
      return 0;
    }
    else if (colCount >= 4 && rowCount >= 4) { 
      return 1;
    }
    else if (colCount < 4 && rowCount >= 4) { 
      return 2;
    }
    else if (colCount >= 4 && rowCount < 4) { 
      return 3;
    }
    return -1; 
  }

  // makes the u pattern on the passed in board
  public void buildU(ArrayList<ArrayList<GamePiece>> currentBoard) {
    for (int r = 0; r < currentBoard.get(0).size(); r++) { 
      if ((r != (currentBoard.get(0).size() - 1)) && r != 0) { 
        currentBoard.get(0).get(r).top = true;
        currentBoard.get(0).get(r).bottom = true;
        currentBoard.get(currentBoard.size() - 1).get(r).top = true;
        currentBoard.get(currentBoard.size() - 1).get(r).bottom = true;
      }
      else if (r == 0) { // top row
        currentBoard.get(0).get(r).bottom = true;
        currentBoard.get(currentBoard.size() - 1).get(r).bottom = true;
      }
      else if (r == (currentBoard.get(0).size() - 1)) { 
        for (int c = 1; c < currentBoard.size() - 1; c++) { 
          currentBoard.get(c).get(r).left = true;
          currentBoard.get(c).get(r).right = true;
        }
        currentBoard.get(0).get(r).top = true;
        currentBoard.get(0).get(r).right = true;
        currentBoard.get(currentBoard.size() - 1).get(r).top = true;
        currentBoard.get(currentBoard.size() - 1).get(r).left = true;
      }
    }

  }

  // builds the board, does not create connections or powerStation
  public ArrayList<ArrayList<GamePiece>> spawnBoard() {
    ArrayList<ArrayList<GamePiece>> genBoard = new ArrayList<ArrayList<GamePiece>>();
    for (int c = 0; c < this.width; c++) {
      genBoard.add(new ArrayList<GamePiece>());
      for (int r = 0; r < this.height; r++) {
        genBoard.get(c).add(new GamePiece(r, c, false, false, false, false));
      }
    }

    return genBoard;

  }

  // takes in a grid of gamepieces and rotates each piece by a random integer
  public void randomizeGrid(ArrayList<GamePiece> nodes) {
    for (GamePiece node : nodes) {
      int numRotations = this.rand.nextInt(4);
      for (int i = 0; i < numRotations; i++) {
        node.rotatePiece(1);
      }
    }
  }

  // handles clicks
  public void onMouseClicked(Posn mouse, String button) {
    GamePiece clicked = locatePiece(mouse);
    if (button.equals("LeftButton")) { 
      clicked.rotatePiece(1);
      this.score++; 
    }
    else if (button.equals("RightButton")) { 
      clicked.rotatePiece(-1);
      this.score++; 
    }
    updateAllNeighbors();
    updatePower(this.board);
    checkGameOver(this.nodes, this.score, this.time);
  }

  // adds all the neighbors to each cell of the game board
  public void updateAllNeighbors() {

    for (GamePiece g : nodes) {
      g.newNeighbor("top", null);
      g.newNeighbor("right", null);
      g.newNeighbor("bottom", null);
      g.newNeighbor("left", null);
    }
    for (int c = 0; c < this.width; c++) {
      int left = c - 1;
      int right = c + 1;
      for (int r = 0; r < this.height; r++) {
        int top = r - 1;
        int bottom = r + 1;
        if (top >= 0) {
          this.board.get(c).get(r).newNeighbor("top", this.board.get(c).get(top));
        }
        if (bottom < this.height) {
          this.board.get(c).get(r).newNeighbor("bottom", this.board.get(c).get(bottom));
        }
        if (left >= 0) {
          this.board.get(c).get(r).newNeighbor("left", this.board.get(left).get(r));
        }
        if (right < this.width) {
          this.board.get(c).get(r).newNeighbor("right", this.board.get(right).get(r));
        }
      }
    }
  }

  // finds the cell at the given posn
  public GamePiece locatePiece(Posn mouse) {
    int row = (int) Math.floor(mouse.y / LightEmAll.CELL_SIZE);
    int col = (int) Math.floor(mouse.x / LightEmAll.CELL_SIZE);
    return this.board.get(col).get(row);
  }

  // draws the scene
  public WorldScene makeScene() {
    int boardWidth = this.width * LightEmAll.CELL_SIZE;
    int boardHeight = this.height * LightEmAll.CELL_SIZE;
    WorldScene gameScene = new WorldScene(0, 0);
    WorldImage scoreBoard = new OverlayImage(
        new TextImage(Integer.toString(this.score), LightEmAll.CELL_SIZE, Color.GREEN),
        new OverlayImage(
            new RectangleImage(3 * CELL_SIZE, (int) 1.2 * CELL_SIZE, OutlineMode.SOLID,
                Color.black),
            new RectangleImage(boardWidth, 2 * CELL_SIZE, OutlineMode.SOLID, Color.lightGray)));
    for (int c = 0; c < this.width; c++) {
      for (int r = 0; r < this.height; r++) {
        gameScene.placeImageXY(
            this.board.get(c).get(r).drawPiece(this.radius)
            .movePinhole((-.5 * LightEmAll.CELL_SIZE), (-.5 * LightEmAll.CELL_SIZE)),
            (c * LightEmAll.CELL_SIZE), (r * LightEmAll.CELL_SIZE));
      }
    }
    gameScene.placeImageXY(scoreBoard, boardWidth / 2, boardHeight + CELL_SIZE);
    gameScene.placeImageXY(new TextImage("Press space to restart.", 10, Color.BLACK),
        boardWidth / 2, boardHeight + (CELL_SIZE / 4));
    gameScene.placeImageXY(
        new TextImage("Time: " + Integer.toString((int) (this.time / 4)), 10, Color.BLACK),
        boardWidth / 2, boardHeight + CELL_SIZE + (3 * (CELL_SIZE / 4)));
    return gameScene;
  }

  // restarts the game
  public void restartGame() {
    LightEmAll newGame = new LightEmAll(this.width, this.height);
    this.board = newGame.board;
    this.nodes = newGame.nodes;
    this.mst = newGame.mst;
    this.width = newGame.width;
    this.height = newGame.height;
    this.powerRow = newGame.powerRow;
    this.powerCol = newGame.powerCol;
    this.radius = newGame.radius;
    this.rand = newGame.rand;
    this.score = newGame.score;
    this.gameEnd = newGame.gameEnd;
    this.time = newGame.time;
  }

  // powers the board
  public void updatePower(ArrayList<ArrayList<GamePiece>> targetBoard) {
    for (GamePiece g : this.nodes) {
      g.powered = 0;
    }
    targetBoard.get(powerCol).get(powerRow).powerStation = true; 
    targetBoard.get(powerCol).get(powerRow).powered = this.radius; 
    targetBoard.get(powerCol).get(powerRow).powerAdjacent(new ArrayList<GamePiece>());
  }

  // grabs the farthest reachable node from the given node
  public GamePiece acquireFarthestNode(GamePiece startNode) {
    HashMap<GamePiece, Integer> distMap = newMapDistance(startNode);
    GamePiece farthestNode = startNode;
    int max = 0;
    for (Map.Entry<GamePiece, Integer> entry : distMap.entrySet()) {
      GamePiece key = entry.getKey();
      Integer value = entry.getValue();
      if (value > max) {
        max = value;
        farthestNode = key;
      }
    }
    return farthestNode;
  }

  // calculates the diameter of this game
  public int calcDiameter() {
    GamePiece farthestFromPower = this.acquireFarthestNode(this.board.get(powerCol).get(powerRow));
    GamePiece farthestSecond = this.acquireFarthestNode(farthestFromPower);
    return newMapDistance(farthestFromPower).get(farthestSecond) + 1;
  }

  // creates a distance map of all the GamePieces reachable from the passed in GamePiece
  public HashMap<GamePiece, Integer> newMapDistance(GamePiece startNode) {
    ArrayList<String> directions = new ArrayList<String>(
        Arrays.asList("left", "right", "top", "bottom"));
    ArrayDeque<GamePiece> queue = new ArrayDeque<GamePiece>();
    ArrayList<GamePiece> seen = new ArrayList<GamePiece>();
    HashMap<GamePiece, Integer> distMap = new HashMap<GamePiece, Integer>();
    queue.addFirst(startNode);
    distMap.put(startNode, 0);
    while (!queue.isEmpty()) {
      GamePiece next = queue.removeFirst();
      if (!seen.contains(next)) {
        seen.add(next);
        for (String dir : directions) { 
          if (next.isConnectedTo(dir) && !seen.contains(next.neighbors.get(dir))) {
            queue.addFirst(next.neighbors.get(dir));
            distMap.put(next.neighbors.get(dir), distMap.get(next) + 1);
          }
        }
      }
    }
    return distMap;
  }

  // handles key events
  public void onKeyEvent(String pressedKey) {
    GamePiece powerStationPiece = this.board.get(powerCol).get(powerRow);
    if (pressedKey.equals("up") && this.powerRow > 0 && powerStationPiece.isConnectedTo("top")) {
      this.board.get(powerCol).get(powerRow).powerStation = false;
      this.powerRow -= 1;
    }
    if (pressedKey.equals("down") && this.powerRow < this.height - 1
        && powerStationPiece.isConnectedTo("bottom")) {
      this.board.get(powerCol).get(powerRow).powerStation = false;
      this.powerRow += 1;
    }
    if (pressedKey.equals("left") && this.powerCol > 0 && powerStationPiece.isConnectedTo("left")) {
      this.board.get(powerCol).get(powerRow).powerStation = false;
      this.powerCol -= 1;
    }
    if (pressedKey.equals("right") && this.powerCol < this.width - 1
        && powerStationPiece.isConnectedTo("right")) {
      this.board.get(powerCol).get(powerRow).powerStation = false;
      this.powerCol += 1;
    }
    if (pressedKey.equals(" ") && this.powerCol < this.width) { // restarts the game
      restartGame();
    }
    updatePower(this.board);
  }

  // will run onTick functions
  public void onTick() {
    this.time++;
    checkGameOver(this.nodes, this.score, this.time);
  }

  // ends the world and checks win/loss
  public WorldEnd endOfTheWorld() {
    int middleX = (int) (this.width * CELL_SIZE) / 2;
    int middleY = (int) (this.height * CELL_SIZE) / 2;
    WorldScene end = this.getEmptyScene();
    if (this.gameEnd == 1) {
      end.placeImageXY(new TextImage("You Win!", CELL_SIZE, Color.GREEN), middleX, middleY);
      return new WorldEnd(true, end);
    }
    else if (this.gameEnd == -1) {
      end.placeImageXY(new TextImage("You Lose!", CELL_SIZE, Color.RED), middleX, middleY);
      return new WorldEnd(true, end);
    }
    else {
      return new WorldEnd(false, this.makeScene());
    }
  }

  // will check game end state
  public void checkGameOver(ArrayList<GamePiece> nodes, int currScore, int currTime) {
    boolean win = true;
    boolean loss = true;
    for (GamePiece node : nodes) {
      if (node.powered < 1) {
        win = false;
      }
    }
    if (this.score < maxScore && this.time < maxTime) {
      loss = false;
    }

    if (win) {
      this.gameEnd = 1; 
    }
    else if (loss) {
      this.gameEnd = -1; 
    }
    else {
      this.gameEnd = 0; 
    }
  }

  // creates a list of all the possible edges
  public ArrayList<Edge> genAllValidEdges(ArrayList<ArrayList<GamePiece>> board) {
    ArrayList<Edge> ret = new ArrayList<Edge>();
    for (int c = 0; c < this.width; c++) {
      for (int r = 0; r < this.height; r++) {
        if (c < this.width - 1) {
          ret.add(new Edge(board.get(c).get(r), board.get(c + 1).get(r), this.rand.nextInt(200)));
        }

        if (r < this.height - 1) {
          ret.add(new Edge(board.get(c).get(r), board.get(c).get(r + 1), this.rand.nextInt(200)));
        }
      }
    }
    return ret;
  }

  // calculates the MST given the edges
  public ArrayList<Edge> generateMST(ArrayList<Edge> edges) {
    HashMap<GamePiece, GamePiece> representatives = new HashMap<GamePiece, GamePiece>();
    ArrayList<Edge> ret = new ArrayList<Edge>();
    ArrayDeque<Edge> queue = new ArrayDeque<Edge>();
    ArrayList<Edge> sortedEdges = edges;
    Collections.sort(sortedEdges, new SortByWeight());
    for (Edge e : sortedEdges) {
      queue.addLast(e);
    }

    // setting every GamePiece to have itself as a representative
    for (GamePiece p : this.nodes) {
      representatives.put(p, p);
    }
    // while the work list isn't empty
    while (!queue.isEmpty()) {
      Edge next = queue.removeFirst();
      if (find(representatives, next.fromNode) == find(representatives, next.toNode)) {
        // adding this edge would not cause a cycle
        // so do nothing
      }
      else {
        ret.add(next);
        union(representatives, find(representatives, next.fromNode),
            find(representatives, next.toNode));
      }
    }
    return ret;
  }

  // finds the representative of the given GamePiece
  GamePiece find(HashMap<GamePiece, GamePiece> reps, GamePiece key) {
    if (reps.get(key).equals(key)) {
      return key;
    }
    else {
      return find(reps, reps.get(key));
    }
  }

  // EFFECT: updates the representatives of the hashmap with the given pieces 
  public void union(HashMap<GamePiece, GamePiece> reps, GamePiece from, GamePiece to) {
    reps.put(from, to);
  }

  // makes the initial representatives hashmap for Kruskals
  public HashMap<GamePiece, GamePiece> initRep(ArrayList<GamePiece> nodes) {
    HashMap<GamePiece, GamePiece> ret = new HashMap<GamePiece, GamePiece>();
    for (GamePiece node : nodes) {
      ret.put(node, node);
    }
    return ret;
  }

  // creates all the board connections where the edges are
  public void newEdgeLink() {
    for (Edge e : this.mst) {
      e.createConnections();
    }
  }
}

//compares the weight of 2 edges
class SortByWeight implements Comparator<Edge> {

  public int compare(Edge edge1, Edge edge2) {
    return edge1.weight - edge2.weight;
  }
}

class Edge {
  GamePiece fromNode;
  GamePiece toNode;
  int weight;

  Edge(GamePiece fromNode, GamePiece toNode, int weight) {
    this.fromNode = fromNode;
    this.toNode = toNode;
    this.weight = weight;
  }

  void createConnections() {
    if (this.fromNode.row == this.toNode.row) {
      this.fromNode.right = true;
      this.toNode.left = true;
    }
    else {
      this.fromNode.bottom = true;
      this.toNode.top = true;
    }
  }
}

//a piece in the game
class GamePiece {
  int row;
  int col;
  boolean left;
  boolean right;
  boolean top;
  boolean bottom;
  boolean powerStation;
  int powered;
  HashMap<String, GamePiece> neighbors;

  GamePiece(int row, int col, HashMap<String, GamePiece> neighbors, boolean left, boolean right,
      boolean top, boolean bottom, boolean powerStation, int powerLevel) {
    this.row = row;
    this.col = col;
    this.left = left;
    this.right = right;
    this.top = top;
    this.bottom = bottom;
    this.powerStation = powerStation;
    this.powered = powerLevel;
    this.neighbors = neighbors;
    this.neighbors.put("left", null);
    this.neighbors.put("right", null);
    this.neighbors.put("top", null);
    this.neighbors.put("bottom", null);

  }

  GamePiece(int row, int col, boolean left, boolean right, boolean top, boolean bottom,
      boolean powerStation) {
    this(row, col, new HashMap<String, GamePiece>(), left, right, top, bottom, powerStation, 0);

  }

  // convenience constructor for all inputs but powerStation
  GamePiece(int row, int col, boolean left, boolean right, boolean top, boolean bottom) {
    this(row, col, left, right, top, bottom, false);
  }

  // convenience constructors for non powerStations, up and down connections
  GamePiece(int row, int col) {
    this(row, col, false, false, true, true, false);
  }

  GamePiece() {

  }

  
  // draws the GamePiece
  public WorldImage drawPiece(int radius) {
    WorldImage base = new RectangleImage(LightEmAll.CELL_SIZE, LightEmAll.CELL_SIZE,
        OutlineMode.SOLID, Color.darkGray);
    WorldImage connection = new RectangleImage((int) LightEmAll.CELL_SIZE / 8,
        (int) LightEmAll.CELL_SIZE / 2, OutlineMode.SOLID, calcColor(radius)).movePinhole(0,
            (int) LightEmAll.CELL_SIZE / 4);
    if (this.top) {
      base = new OverlayImage(connection, base);
    }
    base = new RotateImage(base, 90.0);
    if (this.left) {
      base = new OverlayImage(connection, base);
    }
    base = new RotateImage(base, 90.0);
    if (this.bottom) {
      base = new OverlayImage(connection, base);
    }
    base = new RotateImage(base, 90.0);
    if (this.right) {
      base = new OverlayImage(connection, base);
    }
    base = new RotateImage(base, 90.0);
    if (this.powerStation) {
      base = new OverlayImage(
          new StarImage((LightEmAll.CELL_SIZE / 2.5), 8, 2, OutlineMode.SOLID, Color.ORANGE), base);
    }
    return base;
  }

  // gradient color functionality
  public Color calcColor(int radius) {
    if (powered > 0) {
      return new Color(255, 255, 0, (255 / radius * this.powered));
    }
    else {
      return Color.GRAY;
    }
  }

  // rotates the GamePiece

  public void rotatePiece(int dir) {

    boolean ogLeft = this.left;
    boolean ogRight = this.right;
    boolean ogTop = this.top;
    boolean ogBottom = this.bottom;
    if (dir > 0) { 
      this.top = ogLeft;
      this.right = ogTop;
      this.bottom = ogRight;
      this.left = ogBottom;
    }
    else if (dir < 0) { 
      this.top = ogRight;
      this.right = ogBottom;
      this.bottom = ogLeft;
      this.left = ogTop;
    }
  }

  // adds this gp to the neighbors
  void newNeighbor(String location, GamePiece neighbor) {
    this.neighbors.replace(location, neighbor);
  }

  // tests if the passed in piece is the same, mainly used for testing
  public Object isSamePiece(GamePiece that) {
    return this.row == that.row && this.col == that.col && this.left == that.left
        && this.right == that.right && this.top == that.top && this.bottom == that.bottom
        && this.powerStation == that.powerStation && this.powered == that.powered;
  }

  // checks if this GamePiece is connected to the piece in the given direction
  public boolean isConnectedTo(String direction) {
    if (this.neighbors.get(direction) != null) {
      if (direction.equals("top")) {
        return this.neighbors.get(direction).bottom && this.top;
      }
      if (direction.equals("bottom")) {
        return this.neighbors.get(direction).top && this.bottom;
      }
      if (direction.equals("left")) {
        return this.neighbors.get(direction).right && this.left;
      }
      if (direction.equals("right")) {
        return this.neighbors.get(direction).left && this.right;
      }
    }
    return false;
  }

  // sends power thru the neighbors if possible
  public void powerAdjacent(ArrayList<GamePiece> seen) {
    seen.add(this);
    ArrayList<String> directions = new ArrayList<String>(
        Arrays.asList("left", "right", "top", "bottom"));
    if (this.powered > 0) {
      int neighborPowerLevel = this.powered - 1;
      for (String dir : directions) { 
        if (this.isConnectedTo(dir) && !seen.contains(this.neighbors.get(dir))) {
          this.neighbors.get(dir).powered = neighborPowerLevel;
          this.neighbors.get(dir).powerAdjacent(seen);
        }
      }
    }
  }
}
