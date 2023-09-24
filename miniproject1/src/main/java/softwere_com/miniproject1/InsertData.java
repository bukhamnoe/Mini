package softwere_com.miniproject1;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertData extends JPanel {
    JLabel in_Text[];       //topic for insert
    JLabel in_Head;           //head of insert
    JTextField in_Field[];  //field for insert
    JButton B_insert,B_clear;   //button in insert  
    public InsertData(){
        super(null);
        add_data();
    }
    private void add_data()
    {   
        setSize(300, 420);
        
        //set Head topic of insert
        in_Head = new JLabel("insert data of exam");
            in_Head.setFont(new Font("", Font.BOLD,30));
            in_Head.setHorizontalAlignment(JLabel.CENTER);
        add(in_Head);
        in_Head.setBounds(10, 10, 280, 40);
        //set layout field panel
        JPanel p_field = new JPanel(null);
        
        in_Text = new JLabel[10];
            String s = "Course code : ,Course name : ,Date : ,Time start : ,Time end : ,Sec : ,Room : ,Teacher1 : ,Teacher2 : ,Description : ";
            String sp[] = s.split(",");
        
        in_Field = new JTextField[10];
            String field_ex = "01418111,basic Programing,dd/mm/yyyy,1200,1400,700,LH4-101,kondee,hwangsung,more details";
            String ess[] = field_ex.split(",");
        
        int x=10, y =0;
        for(int i =0 ;i<10 ; i++)
        {
            in_Text[i] = new JLabel(sp[i], JLabel.RIGHT);//set String and close to right side
            in_Field[i] = new JTextField(ess[i]);   
            p_field.add(in_Text[i]);
            p_field.add(in_Field[i]);
            //set position
            in_Text[i].setBounds(x, 10+y, 100, 25); 
            x += 100;
            in_Field[i].setBounds(x, 10+y, 150, 25);
            x =10;
            y+=30;
        }
        add(p_field);
        p_field.setBounds(0, 60, 280, 310);
        //creat button for insert
        B_insert = new JButton("insert");
            B_insert.setActionCommand("insert");
            add(B_insert);
            B_insert.setBounds(40, 370, 70, 40);

        B_clear = new JButton("Clear");
            B_clear.setActionCommand("clear");
            add(B_clear);
            B_clear.setBounds(190, 370, 70, 40);
    }
}
