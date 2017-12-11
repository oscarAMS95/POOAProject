class RepaintTheBoard implements Runnable{
			GUI gameBoard;
			public RepaintTheBoard(GUI gameBoard) {
				this.gameBoard = gameBoard;
			}
			
			public void run() {
				gameBoard.repaint();
			}
		}