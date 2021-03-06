
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.IO;

public class ReasonFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public JLabel tutorialLabel;
	public JButton startButton;
	public JPanel pane;
	
	public ReasonFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Game Innovation Lab - NYU Tandon School of Engineering");
		this.setLocation(300, 100);
	}
	
	@Override
	protected void frameInit() {
		super.frameInit();
		
		startButton = new JButton("Start Experiment");
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Runner.mouseClick = true;
			}
		});
		IO reader = new IO();
		String[] lines = reader.readFile("tutorial/reason.txt");
		String text = "";
		for(String s:lines){
			text += s.trim();
		}
		tutorialLabel = new JLabel(text);
		tutorialLabel.setHorizontalAlignment(JLabel.CENTER);
		
		pane = (JPanel) getContentPane();
		pane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		pane.setAlignmentY(JPanel.CENTER_ALIGNMENT);
	    GroupLayout gl = new GroupLayout(pane);
	    pane.setLayout(gl);
	       
	    pane.setToolTipText("Content pane");
	    gl.setAutoCreateContainerGaps(true);
	    gl.setAutoCreateGaps(true);
	        
	    gl.setHorizontalGroup(gl.createParallelGroup(Alignment.CENTER)
	    		.addComponent(tutorialLabel)
	    		.addComponent(startButton)
	            .addGap(300)
	    );

	    gl.setVerticalGroup(gl.createSequentialGroup()
	    		.addComponent(tutorialLabel)
	    		.addGap(20)
	            .addComponent(startButton)
	    );
	        
	    pack();
	}
}
