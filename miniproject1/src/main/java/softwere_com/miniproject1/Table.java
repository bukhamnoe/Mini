package softwere_com.miniproject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Table extends JPanel {

    String data[][];        //data in the table
    String head_data[] = new String[10];
    JTable table ;
    DefaultTableModel model ;
    TableColumnModel columnModel;
    JScrollPane scrolltable;

    public Table(){
        super(null);
        TableData();
    }

    private void TableData(){ 
        model = new DefaultTableModel(data, head_data);
        table = new JTable(model);
        table.setSize(600, 420);

        // setup width collumn
        columnModel = table.getColumnModel();
        for(int i=0 ;i<10 ;i++)
        {   
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(100);
        }
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //add scroll board in the Table
        scrolltable = new JScrollPane(table);
            scrolltable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrolltable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        add(scrolltable);
        scrolltable.setBounds(0, 0, 600, 420);
        UpdateTable();
    }

    private int CountLine(){
        int count= 0;
        try {       //count line in Data.csv
            File f = new File("./src/main/java/softwere_com/miniproject1/Data.csv");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s , sr[];

            while((s = br.readLine()) != null)
            {
                sr = s.split(",");
                if(sr[0].equals("Course code"))
                    continue;
                count++;
            }
            System.out.println("the line is " +count);
            br.close(); fr.close();
        } catch (Exception e) {
           System.out.println("this error at count line csv :" + e);
        }
        return count;
    }

    protected void UpdateTable(){
        
        data = new String[CountLine()][10];
        
        try {       // put data.csv to string data[][]
            File f = new File("./src/main/java/softwere_com/miniproject1/Data.csv");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s , sr[];
            int i=0;
            while((s = br.readLine()) != null)
            {   //put head data
                sr = s.split(",");
                if(sr[0].equals("Course code"))
                {
                    for(int j=0 ; j<sr.length;j++)
                        head_data[j] = sr[j];
                    continue;
                }
                //put data
                for(int j=0 ; j<sr.length;j++)
                    data[i][j] = sr[j];
                i++;
            }
            br.close();fr.close();
            model.setDataVector(data, head_data);
        } catch (Exception e) {
            System.out.println("this error at input data to String 2d :"+e);
        }
        
    }
}
