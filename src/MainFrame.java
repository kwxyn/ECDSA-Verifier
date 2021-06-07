import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.spec.ECPoint;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultCaret;

import org.apache.commons.codec.digest.DigestUtils;

public class MainFrame {
	
	static String InputJSONPath = "";
	static String InputParametersJSONPath = "";
	static String OutputJSONPath = "";
	
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("ECDSA Verifier");
		mainFrame.setSize(800, 500);
		mainFrame.setLayout(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		
		ImageIcon image = new ImageIcon("logo.png"); // Create an image icon
		mainFrame.setIconImage(image.getImage()); // Set icon for the application
		mainFrame.getContentPane().setBackground(new Color(0x123456)); // Change color of background
		
		// Panels
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setBounds(10,10,150,80);
        topLeftPanel.setBackground(new Color(0x123456));
        topLeftPanel.setLayout(new GridLayout(2,1,10,10));

        JPanel topRightPanel = new JPanel();
        topRightPanel.setBounds(170,10,600,80);
        topRightPanel.setBackground(new Color(0x123456));
        topRightPanel.setLayout(new GridLayout(2,1,10,10));

        JPanel middlePanel = new JPanel();
        middlePanel.setBounds(10,100,760,300);
        middlePanel.setBackground(Color.BLACK);
        middlePanel.setLayout(new BorderLayout(0,0));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(10,410,760,40);
        bottomPanel.setBackground(new Color(0x123456));
        bottomPanel.setLayout(new GridLayout(1,2,400,30));

        // Buttons
        JButton inputJSONFile = new JButton("Input JSON File 1");
        JButton inputParametersJSONFile = new JButton("Input JSON File 2");
//        JButton outputJSONFile = new JButton("Output JSON File");
        JButton exeButton = new JButton("EXECUTE");

        // Text areas
        JTextArea textArea1 = new JTextArea("Digital signature data");
        JTextArea textArea2 = new JTextArea("Curve parameters data");
//        JTextArea textArea3 = new JTextArea("Output to.....");
        JTextArea ConsoleArea = new JTextArea("Ouput console",17,108);
        
        // Label
        JLabel credits = new JLabel("DEVELOPED BY KWAN");
        credits.setForeground(Color.white);
        
        
        textArea1.setBackground(Color.black);
        textArea1.setForeground(Color.GREEN);
        textArea2.setBackground(Color.black);
        textArea2.setForeground(Color.GREEN);
//        textArea3.setBackground(Color.black);
//        textArea3.setForeground(Color.GREEN);
        ConsoleArea.setBackground(Color.black);
        ConsoleArea.setForeground(Color.GREEN);
        
        topLeftPanel.add(inputJSONFile);
        topLeftPanel.add(inputParametersJSONFile);   
//        topLeftPanel.add(outputJSONFile);
        
        topRightPanel.add(textArea1); 
        topRightPanel.add(textArea2);
//        topRightPanel.add(textArea3);
        middlePanel.add(ConsoleArea);
        
        // Scroll bar
        JScrollPane scroll = new JScrollPane (ConsoleArea, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        middlePanel.add(scroll);
        bottomPanel.add(credits);
        bottomPanel.add(exeButton);
        
        
        mainFrame.add(topRightPanel);
        mainFrame.add(topLeftPanel);
        mainFrame.add(middlePanel);
        mainFrame.add(bottomPanel);
        
        scroll.setEnabled(true);
        DefaultCaret caret = (DefaultCaret)ConsoleArea.getCaret(); 
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
		mainFrame.setVisible(true);
		
		
		inputJSONFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					// UPLOAD JSON FILE AND PRINT ON TEXTAREA
					textArea1.setText("");
					JButton open = new JButton("Click me");
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new java.io.File("C://Desktop"));
					fc.setDialogTitle("Directory");
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fc.setFileFilter(new FileNameExtensionFilter("JSON FILES", "json"));
					if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
					}
					
					InputJSONPath = fc.getSelectedFile().getAbsolutePath();
					textArea1.setText(InputJSONPath);

				} catch (Exception event) {
					textArea1.setText("Digital signature data");
					ConsoleArea.setText("ERROR, Please try again");
				}

			}
		});
		
		inputParametersJSONFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					// UPLOAD JSON FILE AND PRINT ON TEXTAREA
					textArea2.setText("");
					JButton open = new JButton("Click me");
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new java.io.File("C://Desktop"));
					fc.setDialogTitle("Directory");
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fc.setFileFilter(new FileNameExtensionFilter("JSON FILES", "json"));
					if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
					}
					
					InputParametersJSONPath = fc.getSelectedFile().getAbsolutePath();
					textArea2.setText(InputParametersJSONPath);

				} catch (Exception event) {
					textArea2.setText("Curve parameters data");
					ConsoleArea.setText("ERROR, Please try again");
				}

			}
		});
//		
//		outputJSONFile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					// UPLOAD JSON FILE AND PRINT ON TEXTAREA
//					textArea3.setText("");
//					JButton open = new JButton("Click me");
//					JFileChooser fc = new JFileChooser();
//					fc.setCurrentDirectory(new java.io.File("C://Desktop"));
//					fc.setDialogTitle("Directory");
//					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//					fc.setFileFilter(new FileNameExtensionFilter("JSON FILES", "json"));
//					if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
//					}
//					
//					OutputJSONPath = fc.getSelectedFile().getAbsolutePath();
//					textArea3.setText(OutputJSONPath);
//
//				} catch (Exception event) {
//					textArea3.setText("Output to.....");
//					ConsoleArea.setText("ERROR, Please try again");
//				}
//
//			}
//		});
		
		 exeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Initialize JSON Reader
				try {
					ConsoleArea.setText("");
					ArrayList<Signature> Signatures = (ArrayList<Signature>) JSONReader.JsonReadForData(InputJSONPath);
					CurveParameters cp =  JSONReader.JSONReadForParameters(InputParametersJSONPath);
					
					//Algorithm can be found in https://cryptobook.nakov.com/digital-signatures/ecdsa-sign-verify-messages#ecdsa-verify-signature
					//Initialize public key EC Point
					ECPoint public_key = cp.getPublic_key();
					//initialize Generator EC Point
					ECPoint gen_point = new ECPoint(cp.getX(),cp.getY()); 
					//initialize private_key
					BigInteger Signature = null;
					//initialize a list of verified signatures
					ArrayList<Signature> verifiedSignatures = new ArrayList<Signature>();
					//initialize a list of unverified signatures
					ArrayList<Signature> unverifiedSignatures = new ArrayList<Signature>();
					BigInteger private_key=null;
					
					//Loop all the signatures in the JSON data
					for(int i=0;i<Signatures.size();i++) 
					{
						//Compute for the BigInteger of the SHA256 hashed messages
						BigInteger hashedMessage = encode(hash(Signatures.get(i).getText()));
						//w = s^-1 mod n
						BigInteger w = (Signatures.get(i).getS()).modInverse(cp.getN());
						//u1 = e*w mod n
						BigInteger u1 = (hashedMessage.multiply(w)).mod(cp.getN());
						//u2 = r*w mod n
						BigInteger u2 = (Signatures.get(i).getR().multiply(w)).mod(cp.getN());
						//Compute the point X = u1*gen_point + u2*pk_point
						ECPoint X = pointAddition(pointMultipy(gen_point, u1,cp),pointMultipy(public_key,u2, cp),cp);
						//v = X.x mod n
						BigInteger v = (X.getAffineX()).mod(cp.getN());
						//Verify the signature if and only if v=r else, reject the signature
						if(v.equals(Signatures.get(i).getR())) //Verified condition
						{
							verifiedSignatures.add(
									new Signature(
									Signatures.get(i).getText(),
									Signatures.get(i).getR(), 
									Signatures.get(i).getS()));
							ConsoleArea.append(Signatures.get(i).getText() + " is verified\nr :" + Signatures.get(i).getR() + "\ns :" + Signatures.get(i).getS()+ "\n\n");		
						}
						else //not Verified condition
						{
							 unverifiedSignatures.add(
									new Signature(
									Signatures.get(i).getText(),
									Signatures.get(i).getR(), 
									Signatures.get(i).getS()));
							 ConsoleArea.append(Signatures.get(i).getText() + " is not verified\nr :" + Signatures.get(i).getR() + "\ns :" + Signatures.get(i).getS()+ "\n\n");	
						}
						
						// Cracking for the private key just like Sony PS3 Homebrew
						for(int j=0;j<Signatures.size();j++)
						{
							if(Signatures.get(i).getR().equals(Signatures.get(j).getR()) && i!=j) //if two R values same
							{
								BigInteger sessionKey = Signatures.get(j).getR(); //Get Session key = same R value
								BigInteger s1 = Signatures.get(i).getS(); //Get signature of first signed message
								BigInteger s2 = Signatures.get(j).getS();//Get signature of second signed message
								
								BigInteger e1 = hashedMessage; //Get integer of hashed digest of first signed message
								BigInteger e2 = encode(hash(Signatures.get(j).getText()));//Get integer of hashed digest of second signed message
								
								BigInteger numerator = (s1.multiply(e2)).subtract(s2.multiply(e1)) ; //S1E2 - S2E1
								BigInteger denominator = sessionKey.multiply(s2.subtract(s1));// R(S2 - S1)
								private_key = numerator.multiply(denominator.modInverse(cp.getN())).mod(cp.getN()); //((S1E2 - S2E1)*(R(S2 - S1))^-1)modulo N
							}
						}
					}
					
					ConsoleArea.append("Number of Verified Signatures: "+ verifiedSignatures.size()+ " out of "+Signatures.size()+"\n");
					ConsoleArea.append("Number of Unverified Signatures: "+ unverifiedSignatures.size()+ " out of "+Signatures.size()+"\n");
					if (private_key!=null)
					{
						ConsoleArea.append("Private key: "+ private_key);
					}
					else
					{
						ConsoleArea.append("Private key is not found ");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					ConsoleArea.setText("ERROR, Please try again");
				}
			}
			 
		 });
	}
	//EC Point addition operation
	public static ECPoint pointAddition(ECPoint p, ECPoint q, CurveParameters fp)
	{	
		//Formula can be found in https://en.m.wikipedia.org/wiki/Elliptic_curve_point_multiplication
		//Modulo the prime number n so that the ECPoint wont not go beyond the curve
		BigInteger numerator = q.getAffineY().subtract(p.getAffineY()); //Yq - Yp
		numerator =  modArithmetic(numerator,fp); //result modulo with prime
		
		BigInteger denominator = q.getAffineX().subtract(p.getAffineX()); //Xq - Xp
		denominator = modArithmetic(denominator,fp); //result modulo with prime
		
		BigInteger lambda  = numerator.multiply(denominator.modInverse(fp.getP())); //(Yq - Yp)*((Xq - Xp)^-1 modulo prime)
		lambda =  modArithmetic(lambda,fp);  //result modulo with prime
		
		BigInteger x = lambda.pow(2).subtract(p.getAffineX()).subtract(q.getAffineX()); //lambda^2 - Xp - Xq
		x = modArithmetic(x,fp); //result module with prime
		
		BigInteger y = (lambda.multiply(p.getAffineX().subtract(x))).subtract(p.getAffineY()); //lambda(Xp - X) - Yp
		y = modArithmetic(y,fp); //result module with prime
		
		return new ECPoint(x,y);
	}
	//EC Point double operation
	public static ECPoint pointDouble(ECPoint p, CurveParameters fp)
	{	
		//Formula can be found in https://crypto.stackexchange.com/questions/64456/problem-on-elliptic-curve-point-doubling
		//Modulo the prime number n so that the ECPoint wont not go beyond the curve
		BigInteger numerator = p.getAffineX().pow(2).multiply(BigInteger.valueOf(3)).add(fp.getA()); //3Xp^2 + a
		numerator =  modArithmetic(numerator,fp); //result modulo with prime
		
		BigInteger denominator = p.getAffineY().multiply(BigInteger.valueOf(2)); //2Yp
		denominator = modArithmetic(denominator,fp); //result modulo with prime
		
		BigInteger lambda  = numerator.multiply(denominator.modInverse(fp.getP())); //(3Xp^2 + a)*((2YP)^-1 modulo prime)
		lambda =  modArithmetic(lambda,fp);  //result modulo with prime
		
		BigInteger x = lambda.pow(2).subtract(p.getAffineX().multiply(BigInteger.valueOf(2))); //lambda^2 - 2Xp
		x = modArithmetic(x,fp); //result module with prime
		
		BigInteger y = (lambda.multiply(p.getAffineX().subtract(x))).subtract(p.getAffineY()); //lambda(Xp - X) - Yp
		y = modArithmetic(y,fp); //result module with prime
		
		return new ECPoint(x,y);
	}
	//EC Point Multiplication operation
	public static ECPoint pointMultipy(ECPoint p, BigInteger x, CurveParameters fp)
	{
		//Formula can be found in https://en.m.wikipedia.org/wiki/Elliptic_curve_point_multiplication
		ECPoint n = new ECPoint(p.getAffineX(),p.getAffineY());

		String binaryX = x.toString(2); //convert BigInteger into Binary representation
		n = p;
		
		//From left to right bits of binary representation
		for(int i=1; i<binaryX.length();i++) //Get each bit value 
		{
			if(Integer.parseInt(binaryX.substring(i, i+1))==1)//if bit = 1
			{
				n = pointDouble(n,fp); //EC point double operation 
				n = pointAddition(n,p,fp); //EC point addition operation 
			}else //if bit = 0
			{
				n = pointDouble(n,fp);//EC point double operation 
			}
		}
		return n;
	}
	public static BigInteger modArithmetic(BigInteger x ,CurveParameters fp) //Result mod Prime p
	{
		return x.mod(fp.getP());
	}
	
	public static String hash(final String text) {
		return DigestUtils.sha256Hex(text);
		}
	
	public static BigInteger encode(final String text) {
		return new BigInteger(text.getBytes(StandardCharsets.UTF_8));
		}

}
