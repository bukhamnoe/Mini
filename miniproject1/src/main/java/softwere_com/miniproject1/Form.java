package softwere_com.miniproject1;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Form extends JFrame implements ActionListener ,KeyListener{
    // layout Jframe
    Container cp;
    GridBagConstraints c = new GridBagConstraints();
    //insert
    InsertData insert = new InsertData();
    //show out
    Table table = new Table();
    
    public Form(){
        super("Examination Schedule system for Teachers");
        initial();
        add_data();
        TableData();
        Finally();
    }
    //set layout Jframe
    private void initial(){
        cp = getContentPane();
        cp.setLayout(new GridBagLayout());
    }
    //creat insert in Jframe
    private void add_data(){   
        for(int i=0 ;i<10 ;i++) { // add action into textField and button
            insert.in_Field[i].addActionListener(this);
        }
        insert.B_insert.addActionListener(this);
        insert.B_clear.addActionListener(this);
        setc(0, 0, 300, 420);
        add(insert,c);
    }
    //creat table in Jframe
    private void TableData(){ 

        setc(1, 0, 600, 420);
        add(table,c);
    }
    private void Finally(){
        setSize(915 , 460);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("insert")){  // When put Insert Button,put all insert.in_field into Data.csv flie
            try {
                File f = new File("./src/main/java/softwere_com/miniproject1/Data.csv");
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (JTextField textField : insert.in_Field)   //loop first textfield till last textfield
                    bw.write(textField.getText() + ",");

                bw.write("\n");
                bw.close(); fw.close();
                System.out.println("Data inserted successfully.");
                
            } catch (IOException ex) {
                System.err.println("Error while inserting data: " + ex.getMessage());
            }
                table.UpdateTable();
                
            
        }else if(e.getActionCommand().equals("clear"))  //when put Clear Button, clear all message in insert.in_Field
        {
            for(int i=0;i<10;i++)
                insert.in_Field[i].setText("");

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource()== insert.in_Field[0])//Check Course code
        {    
            if(!Character.isDigit(e.getKeyChar()))
                e.consume();
        }else if(e.getSource()== insert.in_Field[1])//Check Course name
        {
            if(!Character.isAlphabetic(e.getKeyChar())&& e.getKeyChar() != ' ')
                e.consume();
        }else if(e.getSource()== insert.in_Field[3])//Check Time start
        {
            if(!Character.isDigit(e.getKeyChar()))
                e.consume();
        }else if(e.getSource()== insert.in_Field[4])//Check Time end
        {    
            if(!Character.isDigit(e.getKeyChar()))
                e.consume();
        }else if(e.getSource()== insert.in_Field[5])//Check Sec
        {
            if(!Character.isDigit(e.getKeyChar()))
                e.consume();
        }else if(e.getSource()== insert.in_Field[7])//Check Teacher1
        {
            if(!Character.isAlphabetic(e.getKeyChar())&& e.getKeyChar() != ' ')
                e.consume();
        }else if(e.getSource()== insert.in_Field[8])//Check Teacher2
        {    
            if(!Character.isAlphabetic(e.getKeyChar())&& e.getKeyChar() != ' ')
                e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void setc(int gridx , int gridy ,int ipadx ,int ipady){
        c.gridx = gridx;
        c.gridy = gridy;
        c.ipadx = ipadx;
        c.ipady = ipady;
    }
}
