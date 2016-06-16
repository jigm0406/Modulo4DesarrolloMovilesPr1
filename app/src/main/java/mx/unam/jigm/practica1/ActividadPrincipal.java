package mx.unam.jigm.practica1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActividadPrincipal extends AppCompatActivity implements View.OnClickListener{
   //variables para hacer las operaciones
    Double Num1,Num2,nResultado;
    //para poner el resultado
     TextView txtJDisplay;
    //para ir concatenando los numeros
    String cadena1="",cadena2="",TxtResultado="";
    //cambia cuando se oprime una operación
    Boolean cambia=false;
    //cambia cuando se oprime una vez el punto
    Boolean punto=false;
    //para guardar la operación
    String soperacion="";
    //para cuando eligio una operación
    Boolean Boperacion=false;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        txtJDisplay=(TextView) findViewById(R.id.TxtDisplay);
        //se preparan los botones para escuchar el onclick
        findViewById(R.id.BtnBorrar).setOnClickListener(this);
        findViewById(R.id.Btn7).setOnClickListener(this);
        findViewById(R.id.Btn8).setOnClickListener(this);
        findViewById(R.id.Btn9).setOnClickListener(this);
        findViewById(R.id.BtnDivision).setOnClickListener(this);
        findViewById(R.id.Btn4).setOnClickListener(this);
        findViewById(R.id.Btn5).setOnClickListener(this);
        findViewById(R.id.Btn6).setOnClickListener(this);
        findViewById(R.id.BtnMultiplica).setOnClickListener(this);
        findViewById(R.id.Btn1).setOnClickListener(this);
        findViewById(R.id.Btn2).setOnClickListener(this);
        findViewById(R.id.Btn3).setOnClickListener(this);
        findViewById(R.id.BtnResta).setOnClickListener(this);
        findViewById(R.id.BtnPunto).setOnClickListener(this);
        findViewById(R.id.Btn0).setOnClickListener(this);
        findViewById(R.id.BtnResultado).setOnClickListener(this);
        findViewById(R.id.BtnSuma).setOnClickListener(this);
    }
//para inicializar variables en calculadora
    private void limpia(int nLimpiaDisplay){
        cambia=false;
        cadena1="";
        cadena2="";
        Boperacion=false;
        punto=false;
        if (nLimpiaDisplay==1)
            txtJDisplay.setText("0");
    }
    //para definir operacion
    private void operacion(String Soperacion){
        switch (Soperacion)
        {
            case "/":
                soperacion="/";
                break;
            case "+":
                soperacion="+";
                break;
            case "-":
                soperacion="-";
                break;
            case "*":
                soperacion="*";
                break;
        }
        if (Boperacion==false && cadena1!="")
        {
            cambia=true;
            Boperacion=true;
            punto=false;
            txtJDisplay.setText("");
            }
        else
            Toast.makeText(getApplicationContext(),"Solo una operación",Toast.LENGTH_SHORT).show();

    }
    //para ir concatenando numero en operadores
    private void CadenaNumero(String StrNumero)
    {
        if (cambia==false){
            cadena1=cadena1+StrNumero;
            txtJDisplay.setText(cadena1);}
        else{
            cadena2=cadena2+StrNumero;
            txtJDisplay.setText(cadena2);}
    }
    @Override
    // accion del onclick de los botones
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.BtnBorrar:
                //inicializa
                limpia(1);
                break;
            case R.id.Btn7:
                CadenaNumero("7");
                break;
            case R.id.Btn8:
                CadenaNumero("8");
                break;
            case R.id.Btn9:
                CadenaNumero("9");
                break;
            case R.id.BtnDivision:
                operacion("/");
                break;
            case R.id.Btn4:
                CadenaNumero("4");
                break;
            case R.id.Btn5:
                CadenaNumero("5");
                break;
            case R.id.Btn6:
                CadenaNumero("6");
                break;
            case R.id.BtnMultiplica:
                operacion("*");
                break;
            case R.id.Btn1:
                CadenaNumero("1");
                break;
            case R.id.Btn2:
                CadenaNumero("2");
                break;
            case R.id.Btn3:
                CadenaNumero("3");
                break;
            case R.id.BtnResta:
                operacion("-");
                break;
            case R.id.BtnPunto:
                if (punto==false) {
                    if (cambia = false){
                        cadena1 = cadena1 + ".";
                        punto=true;
                        txtJDisplay.setText(cadena1);}
                    else{
                        cadena2 = cadena2 + ".";
                        punto=true;
                        txtJDisplay.setText(cadena2);}
                }
                else
                //poner toast
                    Toast.makeText(getApplicationContext(),"Solo un punto en número",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Btn0:
                CadenaNumero("0");
                break;
            case R.id.BtnResultado:
                    if (cadena1!="" && cadena2!=""){
                        Num1=Double.parseDouble(cadena1);
                        Num2=Double.parseDouble(cadena2);
                        if (soperacion=="+") nResultado=Num1+Num2;
                        if (soperacion=="-") nResultado=Num1-Num2;
                        if (soperacion=="*") nResultado=Num1*Num2;
                        if (soperacion=="/") nResultado=Num1/Num2;
                        String txtResultado= String.valueOf(nResultado);
                        txtJDisplay.setText(txtResultado);
                        limpia(0);
                    }
                else
                    Toast.makeText(getApplicationContext(),"Se espera un numero",Toast.LENGTH_SHORT).show();
                break;
            case R.id.BtnSuma:
                operacion("+");
                break;
        }
    }
}
