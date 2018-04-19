import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;
import java.io.*;

public class Empleados extends JFrame implements ActionListener {
	

   JFrame fFrame;


       JPanel P0,P1,P2,P3,P4,P5,P6;//panel
       JLabel Lab1,Lab2,Lab3,Lab4,Lab5,Lab6,Lab7,Lab8,Lab9,Lab10,Lab11; //leibol
	   JTextField Tex1,Tex2,Tex3,Tex4,Tex5,Tex6,Tex7,Tex8;
       TextArea Texto;
	   
       //Botones  	   
	   JButton Bot1,Bot2,Bot3,Bot4,Bot5,Bot6,Bot7,Bot8,Bot9;
	   InetAddress DireccionIp = null;  
	
       int CanReg = 0;       

       public Empleados (){
	 
	          setTitle( "EMPLEADO" );			   
			  MenuBar BarraMenu = new MenuBar();
              Menu MenuRedes = new Menu("Redes");
              MenuRedes.add("Direccion IP");

			  BarraMenu.add(MenuRedes);					  
			  setMenuBar(BarraMenu);
			  
			  Lab1 = new JLabel("\t\n   DATOS DEL EMPLEADO   ");
			  
			  Lab2 = new JLabel("Codigo:");
			  Tex1 = new JTextField();
			  Lab3 = new JLabel("Nombre:");
			  Tex2 = new JTextField();
			  Lab4 = new JLabel("Direccion:");
			  Tex3 = new JTextField();
			  Lab7 = new JLabel("Telefono:");
			  Tex4 = new JTextField();
			  Lab8 = new JLabel("Empleo:");
			  Tex5 = new JTextField();
			  Lab9 = new JLabel("Sueldo:");
			  Tex6 = new JTextField();
			  Lab10 = new JLabel("Eliminar Registro:");
			  Tex7 = new JTextField();
			  Lab11 = new JLabel("Buscar Registro:");
			  Tex8 = new JTextField();
			  
			  Lab6 = new JLabel();
			  
			  Bot1 = new JButton("Consultar datos");
			  Bot2 = new JButton("Guardar Registro");
			  Bot3 = new JButton("Modificar registro");
			  Bot4 = new JButton("Eliminar registro");
              Bot5 = new JButton("sonido");
			  Bot6 = new JButton("Salir de la Aplicacion");
              Bot7 = new JButton("Limpiar campos ");
              Bot8 = new JButton("Limpiar texto");
			  Bot9 = new JButton("Buscar");
			  
			  Lab5 = new JLabel("Codigo    Nombre              Direccion               Telefono                 Empleo              Sueldo Bruto                ARS             Suerdo Neto");
			  Texto= new TextArea();	

			  setLayout(new GridLayout(1,1,0,0));
              P0 = new JPanel(new GridLayout(6,0,0,10));	
              P1 = new JPanel(new GridLayout(1,0,0,0));
              P2 = new JPanel(new GridLayout(3,3,0,0));
			  P3 = new JPanel(new GridLayout(1,2,0,0));
              P4 = new JPanel(new GridLayout(4,2,0,0));			
			  P5= new JPanel(new GridLayout(1,0,0,0));	
			  P6 = new JPanel(new GridLayout(1,0,0,0));	        			  
		  
			  P1.add(Lab1);			  
			  P2.add(Lab2);
		      P2.add(Tex1);
			  P2.add(Lab3);
			  P2.add(Tex2);
			  P2.add(Lab4);
              P2.add(Tex3);
			  P2.add(Lab7);
			  P2.add(Tex4);
			  P2.add(Lab8);
			  P2.add(Tex5);
			  P2.add(Lab9);
			  P2.add(Tex6);
			  P3.add(Lab10);
			  P3.add(Tex7);
			  P3.add(Lab11);
			  P3.add(Tex8);

              Bot1.setBackground(Color.orange); 
              P4.add(Bot1); 	
			  Bot2.setBackground(Color.orange); 
              P4.add(Bot2); 
              Bot3.setBackground(Color.orange); 
              P4.add(Bot3); 
              Bot4.setBackground(Color.orange); 
              P4.add(Bot4); 
			  Bot5.setBackground(Color.orange); 
              P4.add(Bot5);
			  Bot6.setBackground(Color.orange); 
              P4.add(Bot6);
			  Bot7.setBackground(Color.orange); 
              P4.add(Bot7);
			  Bot8.setBackground(Color.orange); 
              P4.add(Bot8);
			  Bot9.setBackground(Color.orange); 
              P4.add(Bot9);
			  
			  P1.setBackground(Color.yellow); 
              P0.add( P1);
			  P2.setBackground(Color.gray); 
              P0.add( P2);
			  P3.setBackground(Color.gray); 
              P0.add( P3);
			  P4.setBackground(Color.gray); 
              P0.add( P4);
			  P5.setBackground(Color.gray); 
              P0.add(P5);
			  Texto.setBackground(Color.gray); 
              P0.add(Texto);
              P5.add(Lab5);
			  P6.add(Texto);
			  
              P1.setFont(new Font("Arial",Font.BOLD,20));
              P0.add(P1);	
			  P2.setFont(new Font("Arial",Font.BOLD,15));
              P0.add(P2);
			  P3.setFont(new Font("Arial",Font.BOLD,15));
              P0.add(P3);			  
              //P0.add(P3);
              P0.add(P4);	
              P5.setFont(new Font("Arial",Font.BOLD,20)); 			  
              P0.add(P5);	
              P0.add(P6);		

              add( P0);

              Bot1.addActionListener(this);	
			  Bot2.addActionListener(this);
              Bot3.addActionListener(this);	
              Bot4.addActionListener(this);
			  Bot5.addActionListener(this);
			  Bot6.addActionListener(this);
			  Bot7.addActionListener(this);
			  Bot8.addActionListener(this);
			  Bot9.addActionListener(this);
			 
   try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			}catch(ClassNotFoundException e){
			Texto.append("Error de conexion \n");
			}												 							 
}	   

public boolean handleEvent(Event evento){
	if(Event.WINDOW_DESTROY == evento.id  &&  this == evento.target )System.exit(0);
	switch(evento.id){
	case Event.ACTION_EVENT:{
	if(evento.target instanceof MenuItem){

	if("Direccion IP".equals(evento.arg)){
		try{
			DireccionIp = InetAddress.getLocalHost();
			Texto.append("La direccion IP local es: "+DireccionIp+"\n");
	}catch(UnknownHostException e){
			Texto.append("Error al obtener direccion IP \n");				  
} 		     							                                        
}
}																	  																	  
}												 
}	
return true; 									   
}	
		  
public void actionPerformed(ActionEvent ae){		  
if(ae.getSource() == Bot1){
	try{
		Connection conexion = DriverManager.getConnection("jdbc:odbc:curso2");
		Statement estatuto = conexion.createStatement();	
		ResultSet rs;
		if((Tex6.getText().equals("") == false)||(Tex5.getText().equals("") == false)||(Tex4.getText().equals("") == false)||(Tex3.getText().equals("") == false)||(Tex1.getText().equals("") == false)||(Tex2.getText().equals("") == false)){
		if(Tex6.getText().equals("") == true)Tex6.setText("0");                                                                        
		 rs = estatuto.executeQuery("Select * From Empleado where Codigo = '"+Tex1.getText()+" or Nombre = '"+Tex2.getText()+"' or Direccion = '"+Tex3.getText()+"' or Telefono = '"+Tex4.getText()+"' or Puesto = '"+Tex5.getText()+"'  or  Sueldo = '"+Tex6.getText()+"'");	
		}
		else rs = estatuto.executeQuery("Select * From Empleado");		
						   
        while(rs.next()){
			String codigo = rs.getString("Codigo");
			String nombre = rs.getString("Nombre");
			String direccion = rs.getString("Direccion");
			String telefono = rs.getString("Telefono");
			String puesto = rs.getString("Puesto");
			double sueldo = rs.getDouble("Sueldo");
			Texto.append(codigo+"\t"+nombre+"\t"+direccion+"\t"+telefono+"\t"+puesto+"\t"+sueldo+"\n");	 				 
} 						   
			rs.close();				 
            estatuto.close();
            conexion.close();
			}catch(SQLException e){	 
			Texto.append(e.getMessage());					 
}					    				                                 
}
	
if(ae.getSource() == Bot2){
	try{
	    Connection conexion = DriverManager.getConnection("jdbc:odbc:curso2");
		Statement estatuto = conexion.createStatement();	
		 ResultSet rs;
	if((Tex3.getText().equals("") == false) && (Tex1.getText().equals("") == false) && (Tex2.getText().equals("") == false)){
		rs = estatuto.executeQuery("select * from Empleado where Codigo = '"+Tex1.getText()+"'");
		while(rs.next()){
		CanReg = CanReg+1;							 
}
	if(CanReg > 0)Texto.append("Este codigo ya existe \n");
	else{ 
		estatuto.executeUpdate("Insert Into Empleado(Codigo,Nombre,Direccion,Telefono,Puesto,Sueldo)values('"+Tex1.getText()+"','"+Tex2.getText()+"','"+Tex3.getText()+"','"+Tex4.getText()+"','"+Tex5.getText()+"','"+Tex6.getText()+"')");						                                                                                      		  					                                                                                      
		Texto.append("Este Empleado se ha guardado \n");			
}										                                                                                              }
	else Texto.append("Debe llenar todos los campos \n");											  
		estatuto.close();
        conexion.close();
		CanReg = 0;
	}catch(SQLException e){
		Texto.append(e.getMessage());					 
}					  					  
} 
													 
if(ae.getSource() == Bot3){
	try{
		Connection conexion = DriverManager.getConnection("jdbc:odbc:curso2");
		Statement estatuto = conexion.createStatement();	
		ResultSet rs;
		if((Tex3.getText().equals("") == false) && (Tex1.getText().equals("") == false) && (Tex1.getText().equals("") == false)){
		rs = estatuto.executeQuery("select * from Empleado where Codigo = '"+Tex1.getText()+"'");
	while(rs.next()){
		CanReg = CanReg+1;	
	}
		if(CanReg == 0)Texto.append("Este Empleado no existe \n");
	else{ 
		estatuto.executeUpdate("update Empleado set Codigo = '"+Tex1.getText()+"', Nombre = '"+Tex2.getText()+"', Direccion = '"+Tex3.getText()+"', Telefono= '"+Tex4.getText()+"', Puesto = '"+Tex5.getText()+"', Sueldo = "+Tex6.getText()+" where Codigo = '"+Tex1.getText()+"'");						                                                                                      		  					                                                                                      
	    Texto.append("Los datos de este Empleado se han modificado \n");	
	}
}
    else Texto.append("Debe llenar todos los campos \n");											  
		estatuto.close();
        conexion.close();
		CanReg = 0;
	}catch(SQLException e){
		Texto.append(e.getMessage());				 
		}						  					  
} 
 													 
if(ae.getSource() == Bot4){
	try{
		Connection conexion = DriverManager.getConnection("jdbc:odbc:curso2");
		Statement estatuto = conexion.createStatement();	
		ResultSet rs;
	if(Tex7.getText().equals("") == false){
		rs = estatuto.executeQuery("select * from Empleado where Codigo = '"+Tex7.getText()+"'");
	while(rs.next()){
		CanReg = CanReg+1;							 
}
	if(CanReg == 0)Texto.append("Este Empleado no existe\n");
	else{ 
		estatuto.executeUpdate("delete from Empleado where Codigo = '"+Tex7.getText()+"'");						                                                                                      		  					                                                                                      
		Texto.append("Empleado Eliminado\n");			
}										                                                                                              }
	else Texto.append("Debe introducir el Codigo que desea eliminar \n");											  
		estatuto.close();
		conexion.close();	
		CanReg = 0;
	}catch(SQLException e){
		Texto.append(e.getMessage());	
}						  
}
if(ae.getSource() == Bot5){ 
	Texto.append("Resultado: SONIDO" + "\n");
	AudioClip click;
 
    this.setTitle("NOTA DE VOZ");

	URL urlClick = Empleados.class.getResource("Sonido.wav"); 
	click = Applet.newAudioClip(urlClick);
    click.play();
  }
  
if(ae.getSource() == Bot6){   
    System.exit(0);
}

if(ae.getSource() == Bot7){  
	Tex1.setText("");
	Tex2.setText("");
    Tex3.setText("");
	Tex4.setText("");
	Tex5.setText("");
	Tex6.setText("");
	Tex7.setText("");
	Tex8.setText("");

}
if(ae.getSource() == Bot8){  
    Texto.setText(" ");
}
 

if(ae.getSource() == Bot9){  
	try{
		
		Connection conexion = DriverManager.getConnection("jdbc:odbc:curso2");
		Statement estatuto = conexion.createStatement();	
		ResultSet rs;
	if(Tex8.getText().equals("") == true){
		rs = estatuto.executeQuery("select * from Empleado where Nombre='"+Tex8.getText()+"'");
		}
		else rs = estatuto.executeQuery("Select * From Empleado");		
						   
        while(rs.next()){
			
			String codigo = rs.getString("Codigo");
			String nombre = rs.getString("Nombre");
			String direccion = rs.getString("Direccion");
			String telefono = rs.getString("Telefono");
			String puesto = rs.getString("Puesto");
			double sueldo = rs.getDouble("Sueldo");
			
			
			
			Texto.append(codigo+"\t"+nombre+"\t"+direccion+"\t"+telefono+"\t"+puesto+"\t"+sueldo+"\n");	 				 
} 						   
			rs.close();				 
            estatuto.close();
            conexion.close();
	}catch(SQLException e){
		Texto.append(e.getMessage());	
}			
}

}
public static void main(String args[]){
		Frame Empleados = new Empleados();
		Empleados.resize(700,700);
        Empleados.show();
}			   						  
}