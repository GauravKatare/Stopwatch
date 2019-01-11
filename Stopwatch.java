import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends Main
{

    public Stopwatch(String stopwatch) {
        super(stopwatch);
    }

    public static  void  main(String[] args)
    {
        Stopwatch ss=new Stopwatch("Stopwatch");
        Thread t;
        int a=1;
        Main temp = new Main("Stop");
        temp.face();
        temp.display();
        t= new Thread(temp);
        t.start();
    }
}

class Main extends Frame implements ActionListener,Runnable
{
    int h=0,s=0,m=0,flag=0;
    Button b1,b2,b3,b4;
    TextField second,minute,hour;

    void display()
    {
        second.setText(""+s+"");
        minute.setText(""+m+"");
        hour.setText(""+h+"");
    }

    void check()
    {
        if(s==60) {
            s = 0;
            m++;
            if (m == 60) {
                m = 0;
                h++;
            }
        }
    }

    public  Main(String stopwatch)
    {
        super(stopwatch);
    }

    public void face()
    {
        setLayout(new GridLayout());
        System.out.println("Hello");
        b1=new Button("Exit");
        b2=new Button("Start");
        b3=new Button("Stop");
        b4=new Button("Continue");
        second=new TextField("0");
        minute=new TextField("0");
        hour=new TextField("0");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(second);
        add(minute);
        add(hour);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        setSize(500,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e1)
    {
        if(e1.getSource()==b1)
            System.exit(0);
        else if(e1.getSource()==b2)
        {
            flag=1;
            System.out.println("Reset");
            h=0;m=0;s=0;
        }
        else if(e1.getSource()==b3)
        {
            flag=0;
            System.out.println("Stop");
        }
        else if(e1.getSource()==b4)
        {
            flag=1;
            System.out.println("Continue");
        }
    }

    @Override
    public void run()
    {
        while(true)
        {
            if(flag==1)
            {
                s++;
                check();
                display();
            }    
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                System.out.println("Integer");
            }
        }    
    }
}
