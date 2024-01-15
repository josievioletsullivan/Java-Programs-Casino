//import some GUI repository
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class CardGUI extends JFrame{
	static int screenHeight = 500;
	static int screenWidth = 1000;
	JPanel pnl = new JPanel();
	Color colorBackground = new Color(39,119,20);
	public CardGUI(){
        setSize(CardGUI.screenWidth, CardGUI.screenHeight);
        setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		Board board = new Board();
		setContentPane(board);
	}
	void redraw(){
		removeAll();
		revalidate();
		repaint();
		//clears the screen
		//redraws the screen every time an event happens
	}
	public class Board extends JPanel{
		public Board() {
			Card clubTwo = new Card(2, 0);
			CardDisplay cardDisplay = new CardDisplay(clubTwo);
			this.add(cardDisplay);
			Card clubFour = new Card(2, 3);
			CardDisplay cardDisplay2 = new CardDisplay(clubFour);
			this.add(cardDisplay2);
		}
		public void paintComponent(Graphics g){
			setLayout(new FlowLayout());
			g.setColor(colorBackground);
			g.fillRect(0,0,screenWidth,screenHeight);
			
		}
	}
	
	public class CardDisplay extends JPanel {
		static int cardHeight = 400;
		static int cardWidth = 200;
		private Card card;
		
		public CardDisplay(Card card) {
			this.card = card;
	        setPreferredSize(new Dimension(cardWidth, cardHeight));
	        this.addMouseListener(new MouseHandler());
		}
		
		public void paintComponent(Graphics g){
			setLayout(null);
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, cardWidth, cardHeight);
			g.setColor(Color.BLACK);

			char[] chars = card.getCardName().toCharArray();
			g.drawChars(chars, 0, chars.length, 20, 50);
		}

		private class MouseHandler extends MouseAdapter {
			public void mouseClicked(MouseEvent me) {
				JOptionPane.showMessageDialog(null, "Clicked the " + card.getCardName() + "!");
			}
		}
		
	}

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CardGUI().setVisible(true);
			}
		});
	}

}

