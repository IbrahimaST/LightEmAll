//examples class
class ExamplesLightEmAll {

  // 2x2 GamePieces
  GamePiece twoGamePiece1;
  GamePiece twoGamePiece2;
  GamePiece twoGamePiece3;
  GamePiece twoGamePiece4;

  ArrayList<GamePiece> mt;
  GamePiece gp1;
  GamePiece gp2;
  GamePiece gp3;
  GamePiece gp4;
  GamePiece gp5;
  GamePiece gp6;
  GamePiece gp7;
  GamePiece gp8;
  GamePiece gp9;
  ArrayList<GamePiece> row1;
  ArrayList<GamePiece> row2;
  ArrayList<GamePiece> row3;
  ArrayList<ArrayList<GamePiece>> grid1;
  ArrayList<GamePiece> grid1Nodes;
  LightEmAll game1;
  LightEmAll game2;

  // making a 3 x 5 grid
  GamePiece gp01;
  GamePiece gp02;
  GamePiece gp03;
  GamePiece gp04;
  GamePiece gp05;
  GamePiece gp06;
  GamePiece gp07;
  GamePiece gp08;
  GamePiece gp09;
  GamePiece gp10;
  GamePiece gp11;
  GamePiece gp12;
  GamePiece gp13;
  GamePiece gp14;
  GamePiece gp15;
  ArrayList<GamePiece> row01;
  ArrayList<GamePiece> row02;
  ArrayList<GamePiece> row03;
  ArrayList<ArrayList<GamePiece>> grid3;
  ArrayList<GamePiece> grid3Nodes;
  LightEmAll game3;

  HashMap<String, GamePiece> gp1Neighbors;
  HashMap<String, GamePiece> gp2Neighbors;
  HashMap<String, GamePiece> gp3Neighbors;
  HashMap<String, GamePiece> gp4Neighbors;
  HashMap<String, GamePiece> gp5Neighbors;
  HashMap<String, GamePiece> gp6Neighbors;
  HashMap<String, GamePiece> gp7Neighbors;
  HashMap<String, GamePiece> gp8Neighbors;
  HashMap<String, GamePiece> gp9Neighbors;

  HashMap<String, GamePiece> twoGamePiece1Neighbors;
  HashMap<String, GamePiece> twoGamePiece2Neighbors;
  HashMap<String, GamePiece> twoGamePiece3Neighbors;
  HashMap<String, GamePiece> twoGamePiece4Neighbors;

  LightEmAll twoByTwoBlank;
  LightEmAll twoByTwo;
  LightEmAll threeByThreeU;
  LightEmAll tenByTen;
  LightEmAll fourByFour;

  ArrayList<Edge> emptyEdges;

  public void initData() {
    this.mt = new ArrayList<GamePiece>();

    this.gp1Neighbors = new HashMap<String, GamePiece>();
    this.gp2Neighbors = new HashMap<String, GamePiece>();
    this.gp3Neighbors = new HashMap<String, GamePiece>();
    this.gp4Neighbors = new HashMap<String, GamePiece>();
    this.gp5Neighbors = new HashMap<String, GamePiece>();
    this.gp6Neighbors = new HashMap<String, GamePiece>();
    this.gp7Neighbors = new HashMap<String, GamePiece>();
    this.gp8Neighbors = new HashMap<String, GamePiece>();
    this.gp9Neighbors = new HashMap<String, GamePiece>();

    this.twoGamePiece1Neighbors = new HashMap<String, GamePiece>();
    this.twoGamePiece2Neighbors = new HashMap<String, GamePiece>();
    this.twoGamePiece3Neighbors = new HashMap<String, GamePiece>();
    this.twoGamePiece4Neighbors = new HashMap<String, GamePiece>();

    this.twoGamePiece1 = new GamePiece(0, 0, this.twoGamePiece1Neighbors, false, false, false, true,
        true, 3);
    this.twoGamePiece2 = new GamePiece(1, 0, this.twoGamePiece2Neighbors, false, true, true, false,
        false, 2);
    this.twoGamePiece3 = new GamePiece(1, 1, this.twoGamePiece3Neighbors, true, false, true, false,
        false, 1);
    this.twoGamePiece4 = new GamePiece(0, 1, this.twoGamePiece4Neighbors, false, false, false, true,
        false, 0);

    this.twoGamePiece1Neighbors.put("bottom", this.twoGamePiece2);
    this.twoGamePiece1Neighbors.put("right", this.twoGamePiece4);
    this.twoGamePiece2Neighbors.put("top", this.twoGamePiece1);
    this.twoGamePiece2Neighbors.put("right", this.twoGamePiece3);
    this.twoGamePiece3Neighbors.put("left", this.twoGamePiece2);
    this.twoGamePiece3Neighbors.put("top", this.twoGamePiece4);
    this.twoGamePiece4Neighbors.put("bottom", this.twoGamePiece3);
    this.twoGamePiece4Neighbors.put("left", this.twoGamePiece1);

    this.gp1 = new GamePiece(0, 0, this.gp1Neighbors, false, false, false, true, true,
        0);
    this.gp2 = new GamePiece(1, 0, this.gp2Neighbors, false, false, false, true,
        false, 0);
    this.gp3 = new GamePiece(2, 0, this.gp3Neighbors, false, false, false, true,
        false, 0);
    this.gp4 = new GamePiece(0, 1, this.gp4Neighbors, false, true, true, true, false,
        0);
    this.gp5 = new GamePiece(1, 1, this.gp5Neighbors, true, true, true, true, false,
        0);
    this.gp6 = new GamePiece(2, 1, this.gp6Neighbors, true, false, true, true, false,
        0);
    this.gp7 = new GamePiece(0, 2, this.gp7Neighbors, false, false, false, true,
        false, 0);
    this.gp8 = new GamePiece(1, 2, this.gp8Neighbors, false, false, true, false,
        false, 0);
    this.gp9 = new GamePiece(2, 2, this.gp9Neighbors, false, false, false, true,
        false, 0);

    this.gp1Neighbors.put("right", gp2);
    this.gp1Neighbors.put("bottom", gp4);
    this.gp2Neighbors.put("left", gp1);
    this.gp2Neighbors.put("right", gp3);
    this.gp2Neighbors.put("bottom", gp5);
    this.gp3Neighbors.put("bottom", gp6);
    this.gp3Neighbors.put("left", gp2);
    this.gp4Neighbors.put("top", gp1);
    this.gp4Neighbors.put("bottom", gp7);
    this.gp4Neighbors.put("right", gp5);
    this.gp5Neighbors.put("left", gp4);
    this.gp5Neighbors.put("top", gp2);
    this.gp5Neighbors.put("right", gp6);
    this.gp5Neighbors.put("bottom", gp8);
    this.gp6Neighbors.put("top", gp3);
    this.gp6Neighbors.put("left", gp5);
    this.gp6Neighbors.put("bottom", gp9);
    this.gp7Neighbors.put("top", gp4);
    this.gp7Neighbors.put("right", gp8);
    this.gp8Neighbors.put("top", gp5);
    this.gp9Neighbors.put("top", gp6);

    this.row1 = new ArrayList<GamePiece>();
    this.row1.add(gp1);
    this.row1.add(gp2);
    this.row1.add(gp3);
    this.row2 = new ArrayList<GamePiece>();
    this.row2.add(gp4);
    this.row2.add(gp5);
    this.row2.add(gp6);
    this.row3 = new ArrayList<GamePiece>();
    this.row3.add(gp7);
    this.row3.add(gp8);
    this.row3.add(gp9);
    this.grid1 = new ArrayList<ArrayList<GamePiece>>();
    this.grid1.add(row1);
    this.grid1.add(row2);
    this.grid1.add(row3);
    this.grid1Nodes = new ArrayList<GamePiece>();
    this.grid1Nodes.add(this.gp1);
    this.grid1Nodes.add(this.gp2);
    this.grid1Nodes.add(this.gp3);
    this.grid1Nodes.add(this.gp4);
    this.grid1Nodes.add(this.gp5);
    this.grid1Nodes.add(this.gp6);
    this.grid1Nodes.add(this.gp7);
    this.grid1Nodes.add(this.gp8);
    this.grid1Nodes.add(this.gp9);
    this.game1 = new LightEmAll(3, 3, -1, new Random(3));
    this.game2 = new LightEmAll(10, 10, -1);

    this.gp01 = new GamePiece(0, 0, false, true, false, false);
    this.gp02 = new GamePiece(1, 0, true, true, false, false);
    this.gp03 = new GamePiece(2, 0, true, true, true, true);
    this.gp04 = new GamePiece(3, 0, true, true, false, false);
    this.gp05 = new GamePiece(4, 0, true, false, false, false);
    this.gp06 = new GamePiece(0, 1, false, true, false, false);
    this.gp07 = new GamePiece(1, 1, true, true, false, false);
    this.gp08 = new GamePiece(2, 1, true, true, true, true, true);
    this.gp09 = new GamePiece(3, 1, true, true, false, false);
    this.gp10 = new GamePiece(4, 1, true, false, false, false);
    this.gp11 = new GamePiece(0, 2, false, true, false, false);
    this.gp12 = new GamePiece(1, 2, true, true, false, false);
    this.gp13 = new GamePiece(2, 2, true, true, true, true);
    this.gp14 = new GamePiece(3, 2, true, true, false, false);
    this.gp15 = new GamePiece(4, 2, true, false, false, false);
    this.row01 = new ArrayList<GamePiece>();
    this.row01.add(gp01);
    this.row01.add(gp02);
    this.row01.add(gp03);
    this.row01.add(gp04);
    this.row01.add(gp05);
    this.row02 = new ArrayList<GamePiece>();
    this.row02.add(gp06);
    this.row02.add(gp07);
    this.row02.add(gp08);
    this.row02.add(gp09);
    this.row02.add(gp10);
    this.row03 = new ArrayList<GamePiece>();
    this.row03.add(gp11);
    this.row03.add(gp12);
    this.row03.add(gp13);
    this.row03.add(gp14);
    this.row03.add(gp15);
    this.grid3 = new ArrayList<ArrayList<GamePiece>>();
    this.grid3.add(row01);
    this.grid3.add(row02);
    this.grid3.add(row03);
    this.grid3Nodes = new ArrayList<GamePiece>();
    this.grid3Nodes.add(this.gp01);
    this.grid3Nodes.add(this.gp02);
    this.grid3Nodes.add(this.gp03);
    this.grid3Nodes.add(this.gp07);
    this.grid3Nodes.add(this.gp08);
    this.grid3Nodes.add(this.gp09);
    this.grid3Nodes.add(this.gp10);
    this.grid3Nodes.add(this.gp11);
    this.grid3Nodes.add(this.gp12);
    this.grid3Nodes.add(this.gp13);
    this.grid3Nodes.add(this.gp14);
    this.grid3Nodes.add(this.gp15);
    this.game3 = new LightEmAll(5, 3, 2);

    this.twoByTwoBlank = new LightEmAll(2, 2, -1);
    this.twoByTwo = new LightEmAll(2, 2, 2);
    this.threeByThreeU = new LightEmAll(3, 3, 2);
    this.tenByTen = new LightEmAll(10, 10, 1);
    this.fourByFour = new LightEmAll(4, 4, 1);
    this.emptyEdges = new ArrayList<Edge>();

  }

  // tests for drawPiece
  void testDrawPiece(Tester t) {
    // these tests are based off the coloring of a 10 radius board
    WorldImage base = new RectangleImage(LightEmAll.CELL_SIZE, LightEmAll.CELL_SIZE,
        OutlineMode.SOLID, Color.darkGray);
    initData();
    t.checkExpect(this.game1.board.get(0).get(0).drawPiece(this.game1.radius), new RotateImage(
        new RotateImage(new RotateImage(new RotateImage(base, 90.0), 90.0), 90.0), 90.0));
    t.checkExpect(this.threeByThreeU.board.get(2).get(0).drawPiece(this.game1.radius),
        new RotateImage(
            new RotateImage(
                new OverlayImage(
                    new RectangleImage(5, 20, OutlineMode.SOLID, new Color(128, 128, 128))
                    .movePinhole(0, 10),
                    new RotateImage(new RotateImage(base, 90.0), 90.0)),
                90.0),
            90.0));
    t.checkExpect(this.threeByThreeU.board.get(0).get(0).drawPiece(this.threeByThreeU.radius),
        new OverlayImage(
            new StarImage((LightEmAll.CELL_SIZE / 2.5), 8, 2, OutlineMode.SOLID, Color.ORANGE),
            new RotateImage(new RotateImage(
                new OverlayImage(
                    new RectangleImage(5, 20, OutlineMode.SOLID, new Color(255, 255, 0, 252))
                    .movePinhole(0, 10),
                    new RotateImage(new RotateImage(base, 90.0), 90.0)),
                90.0), 90.0)));
  }

  // tests for calcColor
  void testCalcColor(Tester t) {
    initData();
    t.checkExpect(this.game1.board.get(0).get(0).calcColor(this.game1.width), Color.gray);
    t.checkExpect(this.game3.board.get(0).get(0).calcColor(this.game3.width), Color.YELLOW);
    t.checkExpect(this.game3.board.get(2).get(0).calcColor(this.game3.width), Color.gray);
    t.checkExpect(this.twoByTwo.board.get(0).get(0).calcColor(3), Color.YELLOW);
    t.checkExpect(this.twoByTwo.board.get(1).get(0).calcColor(3), Color.gray);

  }

  // tests for newNeighbor
  void testNewNeighbor(Tester t) {
    initData();
    t.checkExpect(this.game1.nodes.get(0).neighbors.get("right"), null);
    t.checkExpect(this.game1.nodes.get(0).neighbors.get("top"), null);
    t.checkExpect(this.game1.nodes.get(0).neighbors.get("bottom"), null);
    t.checkExpect(this.game1.nodes.get(0).neighbors.get("left"), null);
    this.game1.nodes.get(0).newNeighbor("right", this.gp01);
    t.checkExpect(this.game1.nodes.get(0).neighbors.get("right"), this.gp01);
    t.checkExpect(this.game1.nodes.get(0).neighbors.get("top"), null);
    t.checkExpect(this.game1.nodes.get(0).neighbors.get("left"), null);
    this.game1.nodes.get(0).newNeighbor("bottom", this.gp02);
    t.checkExpect(this.game1.nodes.get(0).neighbors.get("right"), this.gp01);
    t.checkExpect(this.game1.nodes.get(0).neighbors.get("bottom"), this.gp02);
    t.checkExpect(this.game1.nodes.get(0).neighbors.get("left"), null);
  }

  // tests for isSamePiece
  void testIsSamePiece(Tester t) {
    initData();
    t.checkExpect(this.gp01.isSamePiece(this.gp01), true);
    t.checkExpect(this.gp01.isSamePiece(this.gp02), false);
    t.checkExpect(this.gp9.isSamePiece(this.gp9), true);
    t.checkExpect(this.gp9.isSamePiece(this.gp10), false);
    t.checkExpect(this.gp04.isSamePiece(this.gp04), true);
  }

  // tests for isConnectedTo
  void testConnectedTo(Tester t) {
    initData();
    t.checkExpect(this.gp1.isConnectedTo("top"), false);
    t.checkExpect(this.gp1.isConnectedTo("bottom"), true);
    t.checkExpect(this.gp1.isConnectedTo("left"), false);
    t.checkExpect(this.gp1.isConnectedTo("right"), false);

    t.checkExpect(this.gp3.isConnectedTo("top"), false);
    t.checkExpect(this.gp3.isConnectedTo("bottom"), true);
    t.checkExpect(this.gp3.isConnectedTo("left"), false);
    t.checkExpect(this.gp3.isConnectedTo("right"), false);

    t.checkExpect(this.gp5.isConnectedTo("top"), true);
    t.checkExpect(this.gp5.isConnectedTo("bottom"), true);
    t.checkExpect(this.gp5.isConnectedTo("left"), true);
    t.checkExpect(this.gp5.isConnectedTo("right"), true);
  }

  // tests for rotatePiece
  void testRotatePiece(Tester t) {
    initData();
    t.checkExpect(this.gp1.left, false);
    t.checkExpect(this.gp1.top, false);
    t.checkExpect(this.gp1.right, false);
    t.checkExpect(this.gp1.bottom, true);

    this.gp1.rotatePiece(1);

    t.checkExpect(this.gp1.left, true);
    t.checkExpect(this.gp1.top, false);
    t.checkExpect(this.gp1.right, false);
    t.checkExpect(this.gp1.bottom, false);

    t.checkExpect(this.gp2.left, false);
    t.checkExpect(this.gp2.right, false);
    t.checkExpect(this.gp2.bottom, true);

    this.gp2.rotatePiece(1);

    t.checkExpect(this.gp2.left, true);
    t.checkExpect(this.gp2.top, false);
    t.checkExpect(this.gp2.right, false);
    t.checkExpect(this.gp2.bottom, false);

    t.checkExpect(this.gp3.left, false);
    t.checkExpect(this.gp3.top, false);
    t.checkExpect(this.gp3.bottom, true);

    this.gp3.rotatePiece(-1);
    t.checkExpect(this.gp3.left, false);
    t.checkExpect(this.gp3.top, false);
    t.checkExpect(this.gp3.right, true);
    t.checkExpect(this.gp3.bottom, false);
  }

  // tests for powerAdjacent 
  void testPowerNeighbors(Tester t) {
    initData();
    t.checkExpect(this.twoByTwo.board.get(1).get(0).powered, 0);
    t.checkExpect(this.twoByTwo.board.get(0).get(1).powered, 2);

  }

  // tests for spawnBoard
  void testSpawnBoard(Tester t) {
    initData();
    t.checkExpect(this.game1.spawnBoard().size(), 3);
    t.checkExpect(this.game1.spawnBoard().get(0).size(), 3);
    t.checkExpect(this.game2.spawnBoard().size(), 10);
    t.checkExpect(this.game2.spawnBoard().get(0).size(), 10);
  }

  // tests for acquireNodes
  public void testAcquireNodes(Tester t) {
    initData();
    t.checkExpect(this.game1.acquireNodes().size(), 9);
    t.checkExpect(this.game1.nodes.size(), 9);
    t.checkExpect(this.game1.acquireNodes().get(0), this.game1.board.get(0).get(0));
    t.checkExpect(this.game1.acquireNodes().get(2), this.game1.board.get(0).get(2));
    t.checkExpect(this.game1.acquireNodes().get(8), this.game1.board.get(2).get(2));
    t.checkExpect(this.game2.nodes.size(), 100);
  }

  // tests for manualConnections
  public void testManualConnections(Tester t) {
    initData();
    t.checkExpect(this.game1.board.get(0).get(0).right, false);
    t.checkExpect(this.game1.board.get(1).get(1).right, false);
    t.checkExpect(this.game1.board.get(2).get(0).right, false);

    this.game1.generateManualConnections();
    t.checkExpect(this.game1.board.get(0).get(0).right, true);
    t.checkExpect(this.game1.board.get(0).get(0).right, true);
    t.checkExpect(this.game1.board.get(1).get(1).right, true);
    t.checkExpect(this.game1.board.get(1).get(1).bottom, true);
    t.checkExpect(this.game1.board.get(1).get(1).top, true);
    t.checkExpect(this.game1.board.get(2).get(0).right, false);
    t.checkExpect(this.game1.board.get(2).get(0).left, true);

  }

  // tests for generatePartialConnections
  void testGeneratePartialConnections(Tester t) {
    initData();
    t.checkExpect(this.game1.board.get(0).get(0).bottom, false);
    t.checkExpect(this.game1.board.get(0).get(1).bottom, false);
    t.checkExpect(this.game1.board.get(0).get(1).top, false);
    t.checkExpect(this.game1.board.get(0).get(2).right, false);
    t.checkExpect(this.game1.board.get(0).get(2).top, false);
    this.game1.generatePartialConnections(new Posn(0, 0), this.game1.board);
    t.checkExpect(this.game1.board.get(0).get(0).bottom, true);
    t.checkExpect(this.game1.board.get(0).get(1).bottom, true);
    t.checkExpect(this.game1.board.get(0).get(1).top, true);
    t.checkExpect(this.game1.board.get(0).get(2).right, true);
    t.checkExpect(this.game1.board.get(0).get(2).top, true);

    t.checkExpect(this.game2.board.get(0).get(0).bottom, false);
    t.checkExpect(this.game2.board.get(0).get(1).bottom, false);
    t.checkExpect(this.game2.board.get(0).get(1).top, false);
    t.checkExpect(this.game2.board.get(0).get(2).right, false);
    t.checkExpect(this.game2.board.get(0).get(2).top, false);
    t.checkExpect(this.game2.board.get(0).get(2).right, false);
    t.checkExpect(this.game2.board.get(1).get(2).right, false);
    t.checkExpect(this.game2.board.get(1).get(2).left, false);
    t.checkExpect(this.game2.board.get(1).get(2).top, false);
    t.checkExpect(this.game2.board.get(3).get(2).right, false);
    t.checkExpect(this.game2.board.get(3).get(2).top, false);
    t.checkExpect(this.game2.board.get(4).get(7).top, false);
    t.checkExpect(this.game2.board.get(4).get(7).left, false);
    t.checkExpect(this.game2.board.get(4).get(7).bottom, false);

    this.game2.generatePartialConnections(new Posn(0, 0), this.game2.board);
    t.checkExpect(this.game2.board.get(0).get(0).bottom, true);
    t.checkExpect(this.game2.board.get(0).get(1).bottom, true);
    t.checkExpect(this.game2.board.get(0).get(1).top, true);
    t.checkExpect(this.game2.board.get(0).get(2).right, true);
    t.checkExpect(this.game2.board.get(4).get(7).top, true);
    t.checkExpect(this.game2.board.get(4).get(7).left, true);
    t.checkExpect(this.game2.board.get(4).get(7).bottom, true);

  }

  // tests for splitBoard
  void testSplitBoard(Tester t) {
    initData();
    t.checkExpect(this.game2.splitBoard(1, new LightEmAll(4, 4, 2).board).size(), 4);
    t.checkExpect(this.game2.splitBoard(1, new LightEmAll(4, 4, 2).board).get(0).size(), 2);
    t.checkExpect(this.game2.splitBoard(1, new LightEmAll(4, 4, 2).board).get(0).get(0).size(), 2);
    t.checkExpect(this.game2.splitBoard(1, new LightEmAll(4, 4, 2).board).get(1).get(0).size(), 2);
    t.checkExpect(this.game2.splitBoard(1, new LightEmAll(4, 4, 2).board).get(2).get(0).size(), 2);
    t.checkExpect(this.game2.splitBoard(1, new LightEmAll(7, 7, 2).board).get(3).size(), 3);
    t.checkExpect(this.game2.splitBoard(1, new LightEmAll(7, 7, 2).board).get(0).get(0).size(), 4);
    t.checkExpect(this.game2.splitBoard(1, new LightEmAll(7, 7, 2).board).get(1).get(0).size(), 4);
    t.checkExpect(this.game2.splitBoard(1, new LightEmAll(7, 7, 2).board).get(2).get(0).size(), 3);
    t.checkExpect(this.game2.splitBoard(1, new LightEmAll(7, 7, 2).board).get(3).get(0).size(), 3);

  }

  // tests for determineSplitType
  void testDetermineSplitType(Tester t) {
    initData();
    t.checkExpect(this.game2.determineSplitType(game2.board), 1);
    t.checkExpect(this.game2.determineSplitType(new LightEmAll(4, 4, 1).board), 1);
    t.checkExpect(this.game2.determineSplitType(new LightEmAll(3, 4, 1).board), 2);
    t.checkExpect(this.game2.determineSplitType(new LightEmAll(10, 2, 1).board), 3);
    t.checkExpect(this.game2.determineSplitType(new LightEmAll(2, 10, 1).board), 2);
    t.checkExpect(this.game2.determineSplitType(new LightEmAll(7, 7, 1).board), 1);
  }

  // tests for buildU
  void testBuildU(Tester t) {
    initData();
    t.checkExpect(this.game2.board.get(0).get(0).bottom, false);
    t.checkExpect(this.game2.board.get(9).get(0).bottom, false);
    t.checkExpect(this.game2.board.get(0).get(9).top, false);
    t.checkExpect(this.game2.board.get(9).get(9).top, false);
    t.checkExpect(this.game2.board.get(0).get(4).top, false);
    t.checkExpect(this.game2.board.get(9).get(4).top, false);
    t.checkExpect(this.game2.board.get(0).get(4).top, false);
    t.checkExpect(this.game2.board.get(9).get(4).top, false);
    this.game2.buildU(this.game2.board);
    t.checkExpect(this.game2.board.get(0).get(0).bottom, true);
    t.checkExpect(this.game2.board.get(9).get(0).bottom, true);
    t.checkExpect(this.game2.board.get(0).get(9).top, true);
    t.checkExpect(this.game2.board.get(9).get(9).top, true);
    t.checkExpect(this.game2.board.get(0).get(4).top, true);
    t.checkExpect(this.game2.board.get(9).get(4).top, true);
    t.checkExpect(this.game2.board.get(0).get(4).top, true);
    t.checkExpect(this.game2.board.get(9).get(4).top, true);
    initData();
    t.checkExpect(this.twoByTwoBlank.board.get(0).get(0).bottom, false);
    t.checkExpect(this.twoByTwoBlank.board.get(1).get(0).bottom, false);
    t.checkExpect(this.twoByTwoBlank.board.get(0).get(1).top, false);
    t.checkExpect(this.twoByTwoBlank.board.get(1).get(1).top, false);
    this.twoByTwoBlank.buildU(twoByTwoBlank.board);
    t.checkExpect(this.twoByTwoBlank.board.get(0).get(0).bottom, true);
    t.checkExpect(this.twoByTwoBlank.board.get(1).get(0).bottom, true);
    t.checkExpect(this.twoByTwoBlank.board.get(0).get(1).top, true);
    t.checkExpect(this.twoByTwoBlank.board.get(1).get(1).top, true);
  }

  // tests for onMouseClicked
  void testOnMouseClicked(Tester t) {
    initData();
    t.checkExpect(this.game3.board.get(0).get(0).top, false);
    t.checkExpect(this.game3.board.get(0).get(0).right, false);
    t.checkExpect(this.game3.board.get(0).get(0).bottom, true);
    t.checkExpect(this.game3.board.get(0).get(0).left, false);
    t.checkExpect(this.game3.score, 0);

    this.game3.onMouseClicked(new Posn(0, 0), "LeftButton");
    t.checkExpect(this.game3.board.get(0).get(0).top, false);
    t.checkExpect(this.game3.board.get(0).get(0).right, false);
    t.checkExpect(this.game3.board.get(0).get(0).bottom, false);
    t.checkExpect(this.game3.board.get(0).get(0).left, true);
    t.checkExpect(this.game3.score, 1);

    this.game3.onMouseClicked(new Posn(0, 0), "RightButton");
    t.checkExpect(this.game3.board.get(0).get(0).top, false);
    t.checkExpect(this.game3.board.get(0).get(0).right, false);
    t.checkExpect(this.game3.board.get(0).get(0).bottom, true);
    t.checkExpect(this.game3.board.get(0).get(0).left, false);
    t.checkExpect(this.game3.score, 2);

    this.game3.onMouseClicked(new Posn(0, 0), "RightButton");
    t.checkExpect(this.game3.board.get(0).get(0).top, false);
    t.checkExpect(this.game3.board.get(0).get(0).right, true);
    t.checkExpect(this.game3.board.get(0).get(0).bottom, false);
    t.checkExpect(this.game3.board.get(0).get(0).left, false);
    t.checkExpect(this.game3.score, 3);

  }

  // tests for updateAllNeighbors
  public void testUpdateAllNeighbors(Tester t) {
    initData();
    t.checkExpect(this.game1.board.get(0).get(0).neighbors.get("top"), null);
    t.checkExpect(this.game1.board.get(0).get(0).neighbors.get("bottom"), null);
    t.checkExpect(this.game1.board.get(0).get(0).neighbors.get("left"), null);
    t.checkExpect(this.game1.board.get(0).get(0).neighbors.get("right"), null);

    initData();
    this.game1.updateAllNeighbors();
    t.checkExpect(this.game1.board.get(0).get(0).neighbors.get("top"), null);
    t.checkExpect(this.game1.board.get(0).get(0).neighbors.get("left"), null);
    t.checkExpect(this.game1.board.get(0).get(0).neighbors.get("right"),
        this.game1.board.get(1).get(0));
    t.checkExpect(this.game1.board.get(0).get(0).neighbors.get("bottom"),
        this.game1.board.get(0).get(1));

  }

  // tests for locatePiece
  void testLocatePiece(Tester t) {
    initData();
    t.checkExpect(this.game1.locatePiece(new Posn(0, 0)),
        new GamePiece(0, 0, false, false, false, false));
    t.checkExpect(this.game2.locatePiece(new Posn(0, 0)),
        new GamePiece(0, 0, false, false, false, false));
    t.checkExpect(this.game1.locatePiece(new Posn(1, 1)),
        new GamePiece(0, 0, false, false, false, false));
    t.checkExpect(this.game1.locatePiece(new Posn(0, 2)),
        new GamePiece(0, 0, false, false, false, false));
    t.checkExpect(this.game1.locatePiece(new Posn(1, 1)),
        new GamePiece(0, 0, false, false, false, false));
    t.checkExpect(this.twoByTwo.locatePiece(new Posn(0, 0)), this.twoGamePiece1);
    t.checkExpect(this.twoByTwo.locatePiece(new Posn(0, 1)), this.twoGamePiece1);
    t.checkExpect(this.twoByTwo.locatePiece(new Posn(1, 0)), this.twoGamePiece1);
    t.checkExpect(this.twoByTwo.locatePiece(new Posn(1, 1)), this.twoGamePiece1);
    t.checkExpect(this.twoByTwo.locatePiece(new Posn(2, 2)), this.twoGamePiece1);
    t.checkExpect(this.twoByTwo.locatePiece(new Posn(1, 41)), this.twoGamePiece2);
    t.checkExpect(this.twoByTwo.locatePiece(new Posn(41, 41)), this.twoGamePiece3);
    t.checkExpect(this.twoByTwo.locatePiece(new Posn(41, 1)), this.twoGamePiece4);
    t.checkExpect(this.twoByTwo.locatePiece(new Posn(0, 0)), this.twoByTwo.board.get(0).get(0));
    t.checkExpect(this.twoByTwo.locatePiece(new Posn(1, 1)), this.twoByTwo.board.get(0).get(0));
  }

  // tests for restartGame
  void testRestartGame(Tester t) {
    initData();
    this.game1.onMouseClicked(new Posn(1, 1), "LeftButton");
    t.checkExpect(this.game1.score, 1);
    t.checkExpect(this.game1.time, 0);
    this.game1.onTick();
    this.game1.onTick();
    this.game1.onTick();
    this.game1.onTick();
    t.checkExpect(this.game1.time, 4);
    this.game1.restartGame();
    t.checkExpect(this.game1.score, 0);
    t.checkExpect(this.game1.time, 0);

    this.game2.onMouseClicked(new Posn(1, 1), "RightButton");
    t.checkExpect(this.game2.score, 1);
    t.checkExpect(this.game2.time, 0);
    this.game2.onTick();
    t.checkExpect(this.game2.time, 1);
    this.game2.restartGame();
    t.checkExpect(this.game2.score, 0);
    t.checkExpect(this.game2.time, 0);
  }

  // tests for updatePower
  void testUpdatePower(Tester t) {
    initData();
    t.checkExpect(this.twoByTwo.board.get(1).get(0).powerStation, false);
    this.twoByTwo.updatePower(this.twoByTwo.board);
    t.checkExpect(this.twoByTwo.board.get(0).get(0).powerStation, true);

  }

  // tests for generateRandomGrid
  void testGenerateRandomGrid(Tester t) {
    initData();
    this.game1.generatePartialConnections(new Posn(0, 0), this.game1.board);
    t.checkExpect(this.game1.nodes.get(0).left, false);
    t.checkExpect(this.game1.nodes.get(0).top, false);
    t.checkExpect(this.game1.nodes.get(0).right, false);
    t.checkExpect(this.game1.nodes.get(0).bottom, true);
    t.checkExpect(this.game1.nodes.get(4).left, false);
    t.checkExpect(this.game1.nodes.get(4).top, true);
    t.checkExpect(this.game1.nodes.get(4).right, false);
    t.checkExpect(this.game1.nodes.get(4).bottom, true);
    t.checkExpect(this.game1.nodes.get(8).left, true);
    t.checkExpect(this.game1.nodes.get(8).top, true);
    t.checkExpect(this.game1.nodes.get(8).right, false);
    t.checkExpect(this.game1.nodes.get(8).bottom, false);
    t.checkExpect(this.game1.nodes.get(2).left, false);
    t.checkExpect(this.game1.nodes.get(2).top, true);
    t.checkExpect(this.game1.nodes.get(2).right, true);
    t.checkExpect(this.game1.nodes.get(2).bottom, false);
    t.checkExpect(this.game1.nodes.get(6).left, false);
    t.checkExpect(this.game1.nodes.get(6).top, false);
    t.checkExpect(this.game1.nodes.get(6).right, false);
    t.checkExpect(this.game1.nodes.get(6).bottom, true);
    this.game1.randomizeGrid(this.game1.nodes);

    t.checkExpect(this.game1.nodes.get(0).left, false);
    t.checkExpect(this.game1.nodes.get(0).top, false);
    t.checkExpect(this.game1.nodes.get(0).right, true);
    t.checkExpect(this.game1.nodes.get(0).bottom, false);
    t.checkExpect(this.game1.nodes.get(4).left, true);
    t.checkExpect(this.game1.nodes.get(4).top, false);
    t.checkExpect(this.game1.nodes.get(4).right, true);
    t.checkExpect(this.game1.nodes.get(4).bottom, false);
    t.checkExpect(this.game1.nodes.get(8).left, true);
    t.checkExpect(this.game1.nodes.get(8).top, true);
    t.checkExpect(this.game1.nodes.get(8).right, false);
    t.checkExpect(this.game1.nodes.get(8).bottom, false);
    t.checkExpect(this.game1.nodes.get(2).left, false);
    t.checkExpect(this.game1.nodes.get(2).top, true);
    t.checkExpect(this.game1.nodes.get(2).right, true);
    t.checkExpect(this.game1.nodes.get(2).bottom, false);
    t.checkExpect(this.game1.nodes.get(6).left, false);
    t.checkExpect(this.game1.nodes.get(6).top, false);
    t.checkExpect(this.game1.nodes.get(6).right, true);
    t.checkExpect(this.game1.nodes.get(6).bottom, false);

  }

  // tests for onKeyEvent
  void testOnKeyEvent(Tester t) {
    initData();
    t.checkExpect(this.twoByTwo.powerRow, 0);
    this.twoByTwo.onKeyEvent("down");
    t.checkExpect(this.twoByTwo.powerRow, 1);
    this.twoByTwo.onKeyEvent("right");
    t.checkExpect(this.twoByTwo.powerCol, 1);

    t.checkExpect(this.game3.powerRow, 0);
    this.game3.onKeyEvent("down");
    t.checkExpect(this.game3.powerRow, 1);
    this.game3.onKeyEvent("down");
    t.checkExpect(this.game3.powerRow, 2);
    this.game3.onKeyEvent("right");
    t.checkExpect(this.game3.powerCol, 1);
  }

  // tests for checkGameOver
  void testCheckGameOver(Tester t) {
    initData();
    t.checkExpect(this.game2.gameEnd, 0);
    this.game2.checkGameOver(this.game2.nodes, this.game2.score, this.game2.time);
    t.checkExpect(this.game2.gameEnd, 0);

    initData();
    t.checkExpect(this.game2.gameEnd, 0);
    this.game2.time = this.game2.maxTime - 1;
    this.game2.checkGameOver(this.game2.nodes, this.game2.score, this.game2.time);
    t.checkExpect(this.game2.gameEnd, 0);

    initData();
    t.checkExpect(this.game2.gameEnd, 0);
    this.game2.time = this.game2.maxTime;
    this.game2.checkGameOver(this.game2.nodes, this.game2.score, this.game2.time);
    t.checkExpect(this.game2.gameEnd, -1);

    initData();
    t.checkExpect(this.game2.gameEnd, 0);
    this.game2.time = this.game2.maxTime + 1;
    this.game2.checkGameOver(this.game2.nodes, this.game2.score, this.game2.time);
    t.checkExpect(this.game2.gameEnd, -1);

    initData();
    t.checkExpect(this.game2.gameEnd, 0);
    this.game2.score = this.game2.maxScore - 1;
    this.game2.checkGameOver(this.game2.nodes, this.game2.score, this.game2.score);
    t.checkExpect(this.game2.gameEnd, 0);

    initData();
    t.checkExpect(this.game2.gameEnd, 0);
    this.game2.score = this.game2.maxScore;
    this.game2.checkGameOver(this.game2.nodes, this.game2.score, this.game2.score);
    t.checkExpect(this.game2.gameEnd, -1);

    initData();
    t.checkExpect(this.game2.gameEnd, 0);
    this.game2.score = this.game2.maxScore + 1;
    this.game2.checkGameOver(this.game2.nodes, this.game2.score, this.game2.score);
    t.checkExpect(this.game2.gameEnd, -1);

  }

  // tests for onTick
  void testOnTick(Tester t) {
    initData();
    t.checkExpect(this.game1.time, 0);
    this.game1.onTick();
    t.checkExpect(this.game1.time, 1);
    this.game1.onTick();
    t.checkExpect(this.game1.time, 2);
    initData();
    t.checkExpect(this.game1.gameEnd, 0);
    this.game1.time = 99999998;
    this.game1.onTick();
    t.checkExpect(this.game1.time, 99999999);
    t.checkExpect(this.game1.gameEnd, -1);
  }

  // tests for acquireFarthestNode
  void testAcquireFarthestNode(Tester t) {
    initData();
    t.checkExpect(this.threeByThreeU.acquireFarthestNode(this.threeByThreeU.nodes.get(0)),
        this.threeByThreeU.board.get(2).get(0));
    t.checkExpect(this.fourByFour.acquireFarthestNode(this.fourByFour.board.get(0).get(0)),
        this.fourByFour.board.get(0).get(3));
    t.checkExpect(this.fourByFour.acquireFarthestNode(this.fourByFour.board.get(1).get(0)),
        this.fourByFour.board.get(0).get(3));
  }

  // tests for calcDiameter
  void testCalcDiameter(Tester t) {
    initData();
    t.checkExpect(this.threeByThreeU.calcDiameter(), 7);
    t.checkExpect(this.fourByFour.calcDiameter(), 8);
    t.checkExpect(this.tenByTen.calcDiameter(), 20);
  }

  // tests for newMapDistance
  void testNewMapDistance(Tester t) {
    initData();
    t.checkExpect(this.threeByThreeU.newMapDistance(this.threeByThreeU.nodes.get(0))
        .get(this.threeByThreeU.nodes.get(0)), 0);
    t.checkExpect(this.tenByTen.newMapDistance(this.tenByTen.nodes.get(0))
        .get(this.tenByTen.board.get(0).get(2)), 12);
    t.checkExpect(this.tenByTen.newMapDistance(this.tenByTen.nodes.get(0))
        .get(this.tenByTen.board.get(9).get(0)), 9);
    t.checkExpect(this.threeByThreeU.newMapDistance(this.threeByThreeU.nodes.get(0))
        .get(this.threeByThreeU.board.get(0).get(0)), 0);
    t.checkExpect(this.threeByThreeU.newMapDistance(this.threeByThreeU.nodes.get(0))
        .get(this.threeByThreeU.board.get(0).get(2)), 2);
    t.checkExpect(this.threeByThreeU.newMapDistance(this.threeByThreeU.nodes.get(0))
        .get(this.threeByThreeU.board.get(2).get(0)), 6);
  }

  // tests for endOfTheWorld
  void testEndOfTheWorld(Tester t) {
    initData();
    int middleX = (int) (this.game1.width * LightEmAll.CELL_SIZE) / 2;
    int middleY = (int) (this.game1.height * LightEmAll.CELL_SIZE) / 2;
    WorldScene winScene = this.game1.getEmptyScene();
    winScene.placeImageXY(new TextImage("You Win!", LightEmAll.CELL_SIZE, Color.GREEN), middleX,
        middleY);
    WorldScene loseScene = this.game1.getEmptyScene();
    loseScene.placeImageXY(new TextImage("You Lose!", LightEmAll.CELL_SIZE, Color.GREEN), middleX,
        middleY);
    t.checkExpect(this.game1.endOfTheWorld(), new WorldEnd(false, this.game1.makeScene()));
    this.game1.gameEnd = 1;
    t.checkExpect(this.game1.endOfTheWorld(), new WorldEnd(true, winScene));
    initData();
    t.checkExpect(this.game1.endOfTheWorld(), new WorldEnd(false, this.game1.makeScene()));
    this.game1.gameEnd = -1;
    t.checkExpect(this.game1.endOfTheWorld(), new WorldEnd(true, loseScene));
  }

  // tests for genAllValidEdges
  void testGenAllValidEdges(Tester t) {
    initData();
    t.checkExpect(this.game1.genAllValidEdges(this.game1.board).size(), 12);
    t.checkExpect(this.twoByTwo.genAllValidEdges(this.twoByTwo.board).size(), 4);
  }

  // tests for genAllValidEdges
  void testEdges(Tester t) {
    initData();
    this.emptyEdges = this.game1.genAllValidEdges(this.game1.board);
    t.checkExpect(emptyEdges.get(0).weight, 77);
    t.checkExpect(emptyEdges.get(2).weight, 181);
    t.checkExpect(emptyEdges.get(4).weight, 176);
    Collections.sort(this.emptyEdges, new SortByWeight());
    t.checkExpect(emptyEdges.get(0).weight, 6);
    t.checkExpect(emptyEdges.get(1).weight, 14);
    t.checkExpect(emptyEdges.get(2).weight, 77);
    t.checkExpect(emptyEdges.get(3).weight, 86);
    t.checkExpect(emptyEdges.get(4).weight, 92);
  }

  // tests for initRep
  void testInitRep(Tester t) {
    initData();
    t.checkExpect(this.game1.initRep(this.game1.nodes).get(this.game1.nodes.get(0)),
        this.game1.nodes.get(0));
    t.checkExpect(this.game1.initRep(this.game1.nodes).get(this.game1.nodes.get(2)),
        this.game1.nodes.get(2));
    t.checkExpect(this.game1.initRep(this.game1.nodes).get(this.game1.nodes.get(8)),
        this.game1.nodes.get(8));
    t.checkExpect(this.game1.initRep(this.game1.nodes).get(this.game1.nodes.get(1)),
        this.game1.nodes.get(1));

  }

  // tests for newEdgeLink
  void testNewEdgeLink(Tester t) {
    initData();
    t.checkExpect(this.game1.board.get(0).get(0).right, false);
    t.checkExpect(this.game1.board.get(0).get(1).left, false);
    t.checkExpect(this.game1.board.get(0).get(0).bottom, false);
    this.game1.newEdgeLink();
    t.checkExpect(this.game1.board.get(0).get(0).right, true);
    t.checkExpect(this.game1.board.get(0).get(1).left, false);
    t.checkExpect(this.game1.board.get(0).get(0).bottom, true);
  }

  // tests for bigBang, will render the game
  void testBigBang(Tester t) {
    initData();
    LightEmAll game = new LightEmAll(10, 10, 3);
    game.bigBang(game.width * LightEmAll.CELL_SIZE,
        (game.height * LightEmAll.CELL_SIZE) + (LightEmAll.CELL_SIZE * 2), 0.25);
  }

}




