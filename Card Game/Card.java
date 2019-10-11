
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class Card{

	private String name;

	public Card(String card)
	{
		this.name = card;
	}

	private BufferedImage createImage(int w, int h, String filename) 
	{	
		BufferedImage bi = null;
		try
		{
			ImageIcon ii = new ImageIcon(filename);
	    	bi = new BufferedImage(w, h,BufferedImage.TYPE_INT_ARGB);
	    	Graphics2D g2 = (Graphics2D) bi.createGraphics();
	    	g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	    	g2.drawImage(ii.getImage(),0,0,w,h,null);

	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	    return bi;
	}

	private BufferedImage getImage(String name) throws IOException
	{
		this.name = name;

		if(name == "AS")
		{	
			BufferedImage aImg = createImage(100,100,"Spades/Ace_of_Spades.png");
			return aImg;
		}
		else if(name == "2S")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/2_of_Spades.png");
			return aImg;
		}
		else if(name == "3S")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/3_of_Spades.png");
			return aImg;
		}
		else if(name == "4S")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/4_of_Spades.png");
			return aImg;
		}
		else if(name == "5S")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/5_of_Spades.png");
			return aImg;
		}
		else if(name == "6S")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/6_of_Spades.png");
			return aImg;
		}
		else if(name == "7S")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/7_of_Spades.png");
			return aImg;
		}
		else if(name == "8S")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/8_of_Spades.png");
			return aImg;
		}
		else if(name == "9S")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/9_of_Spades.png");
			return aImg;
		}
		else if(name == "10S")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/10_of_Spades.png");
			return aImg;
		}
		else if(name == "KS")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/King_of_Spades.png");
			return aImg;
		}
		else if(name == "QS")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/Queen_of_Spades.png");
			return aImg;
		}
		else if(name == "JS")
		{
			BufferedImage aImg =  createImage(100,100,"Spades/Jack_of_Spades.png");
			return aImg;
		}
		else if(name == "AC")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/Ace_of_Clubs.png");
			return aImg;
		}
		else if(name == "2C")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/2_of_Clubs.png");
			return aImg;
		}
		else if(name == "3C")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/3_of_Clubs.png");
			return aImg;
		}
		else if(name == "4C")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/4_of_Clubs.png");
			return aImg;
		}
		else if(name == "5C")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/5_of_Clubs.png");
			return aImg;
		}
		else if(name == "6C")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/6_of_Clubs.png");
			return aImg;
		}
		else if(name == "7C")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/7_of_Clubs.png");
			return aImg;
		}
		else if(name == "8C")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/8_of_Clubs.png");
			return aImg;
		}
		else if(name == "9C")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/9_of_Clubs.png");
			return aImg;
		}
		else if(name == "10C")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/10_of_Clubs.png");
			return aImg;
		}
		else if(name == "KC")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/King_of_Clubs.png");
			return aImg;
		}
		else if(name == "QC")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/Queen_of_Clubs.png");
			return aImg;
		}
		else if(name == "JC")
		{
			BufferedImage aImg =  createImage(100,100,"Clubs/Jack_of_Clubs.png");
			return aImg;
		}
		else if(name == "AH")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/Ace_of_Hearts.png");
			return aImg;
		}
		else if(name == "1H")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/1_of_hearts.png");
			return aImg;
		}
		else if(name == "2H")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/2_of_hearts.png");
			return aImg;
		}
		else if(name == "3H")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/3_of_hearts.png");
			return aImg;
		}
		else if(name == "4H")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/4_of_hearts.png");
			return aImg;
		}
		else if(name == "5H")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/5_of_hearts.png");
			return aImg;
		}
		else if(name == "6H")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/6_of_hearts.png");
			return aImg;
		}
		else if(name == "7H")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/7_of_hearts.png");
			return aImg;
		}
		else if(name == "8H")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/8_of_hearts.png");
			return aImg;
		}
		else if(name == "9H")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/9_of_hearts.png");
			return aImg;
		}
		else if(name == "10H")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/10_of_hearts.png");
			return aImg;
		}
		else if(name == "KH")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/King_of_hearts.png");
			return aImg;
		}
		else if(name == "QH")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/Queen_of_hearts.png");
			return aImg;
		}
		else if(name == "JH")
		{
			BufferedImage aImg =  createImage(100,100,"Hearts/Jack_of_hearts.png");
			return aImg;
		}
		else if(name == "AD")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/Ace_of_Diamonds.png");
			return aImg;
		}
		else if(name == "1D")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/1_of_Diamonds.png");
			return aImg;
		}
		else if(name == "2D")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/2_of_Diamonds.png");
			return aImg;
		}
		else if(name == "3D")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/3_of_Diamonds.png");
			return aImg;
		}
		else if(name == "4D")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/4_of_Diamonds.png");
			return aImg;
		}
		else if(name == "5D")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/5_of_Diamonds.png");
			return aImg;
		}
		else if(name == "6D")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/6_of_Diamonds.png");
			return aImg;
		}
		else if(name == "7D")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/7_of_Diamonds.png");
			return aImg;
		}
		else if(name == "8D")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/8_of_Diamonds.png");
			return aImg;
		}
		else if(name == "9D")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/9_of_Diamonds.png");
			return aImg;
		}
		else if(name == "10D")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/10_of_Diamonds.png");
			return aImg;
		}
		else if(name == "KD")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/King_of_Diamonds.png");
			return aImg;
		}
		else if(name == "QD")
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/Queen_of_Diamonds.png");
			return aImg;
		}
		else 
		{
			BufferedImage aImg =  createImage(100,100,"Diamonds/Jack_of_Diamonds.png");
			return aImg;
		}
	}

	public void frame() throws IOException
	{

	 	JFrame form = new JFrame("Shithead");
	 	form.setSize(900,900);
   		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   		JPanel content = new JPanel(new BorderLayout());
   		content.setBackground(Color.GREEN);
	 	content.setLayout(null);  

	 	JButton font = new JButton();
	 	font.setText("Player_1");
	 	font.setBounds(50, 20, 100,50 );

	 	JButton font2 = new JButton();
	 	font2.setText("Player_2");
	 	font2.setBounds(50, 180, 100,50 );

	 	JButton font3 = new JButton();
	 	font3.setText("Player_3");
	 	font3.setBounds(50, 340, 100,50 );

	 	Icon path = new ImageIcon("Red_Back.png");
	 	JButton deck = new JButton(path);
	 	deck.setBounds(900,500, 73,101);


		int z = 2;
		for(int q = 0;q<3;q++)
		{	
			JLabel card = new JLabel(new ImageIcon((Image)getImage(name)));		
			Dimension size = card.getPreferredSize();
			card.setBounds(100*z,0, size.width, size.height);
			content.add(card);
			z+=1;
		}	
   		
   		int e = 2;
		for(int q = 0;q<3;q++)
		{	
			JLabel cards = new JLabel(new ImageIcon((Image)getImage(name)));		
			Dimension size = cards.getPreferredSize();
			cards.setBounds(100*e,160, size.width, size.height);
			content.add(cards);
			e+=1;
		}	

		int t = 2;
		for(int q = 0;q<3;q++)
		{	
			JLabel card2 = new JLabel(new ImageIcon((Image)getImage(name)));		
			Dimension size = card2.getPreferredSize();
			card2.setBounds(100*t,320, size.width, size.height);
			content.add(card2);
			t+=1;
		}	

   		content.add(font);
   		content.add(font2);	
   		content.add(font3);
   		content.add(deck);
		form.add(content);	
		form.setVisible(true);
		//form.add(content);
		//form.setVisible(true);
    }



	/* public JLabel showHand() throws IOException
	{
	 	
		int z = 1;
		JLabel card = new JLabel(new ImageIcon((Image)getImage(name)));		
		Dimension size = card.getPreferredSize();
		card.setBounds(100*z,0, size.width, size.height);
		z+=1;
		return card;	

			
		// JLabel font = new JLabel("Hand: ",JLabel.RIGHT);
		// font.setVerticalAlignment(JLabel.CENTER);
		// font.setHorizontalAlignment(JLabel.CENTER);
		// content.add(font);
	}*/
	
	/*public JLabel showFaceUP(int x) throws IOException
	{
		
		JLabel cards = new JLabel(new ImageIcon((Image)getImage(name)));
		Dimension sizes = cards.getPreferredSize();
		cards.setBounds(100*x,200, sizes.width, sizes.height);
		
		for(int i = 0;i<3;i++)
		{	
			cards.setBounds(100*x,200, sizes.width, sizes.height);	
			x += 1;	
			frame(cards,x);
		}	
		return cards;
				
			
	}*/
}
