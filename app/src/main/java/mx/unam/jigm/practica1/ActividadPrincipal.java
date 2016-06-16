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
    private TextView txtJDisplay;
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
        TextView txtJDisplay=(TextView) findViewById(R.id.TxtDisplay);
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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.BtnBorrar:
                //inicializa todo

                break;
            case R.id.Btn7:
                if (cambia==false){
                    cadena1=cadena1+"7";
                    txtJDisplay.setText(cadena1);}
                else{
                    cadena2=cadena2+"7";
                    txtJDisplay.setText(cadena2);}
                break;
            case R.id.Btn8:
                if (cambia==false){
                    cadena1=cadena1+"8";
                    txtJDisplay.setText(cadena1);}
                else{
                    cadena2=cadena2+"8";
                txtJDisplay.setText(cadena2);}
                break;
            case R.id.Btn9:
                if (cambia==false){
                    cadena1=cadena1+"9";
                    txtJDisplay.setText(cadena1);}
                else{
                    cadena2=cadena2+"9";
                    txtJDisplay.setText(cadena2);}
                break;
            case R.id.BtnDivision:
                if (Boperacion==false && cadena1!="")
                {cambia=true;
                soperacion="/";}
                else
                    Toast.makeText(getApplicationContext(),"Solo una operación",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Btn4:
                if (cambia==false){
                    cadena1=cadena1+"4";
                    txtJDisplay.setText(cadena1);}
                else{
                    cadena2=cadena2+"4";
                    txtJDisplay.setText(cadena2);}
                break;
            case R.id.Btn5:
                if (cambia==false){
                    cadena1=cadena1+"5";
                    txtJDisplay.setText(cadena1);}
                else{
                    cadena2=cadena2+"5";
                    txtJDisplay.setText(cadena2);}
                break;
            case R.id.BtnMultiplica:
                if (Boperacion==false && cadena1!="")
                {cambia=true;
                soperacion="*";}
                else
                    Toast.makeText(getApplicationContext(),"Solo una operación",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Btn1:
                if (cambia==false){
                    cadena1=cadena1+"1";
                txtJDisplay.setText(cadena1);}
                else{
                    cadena2=cadena2+"1";
                txtJDisplay.setText(cadena2);}
                break;
            case R.id.Btn2:
                if (cambia==false){
                    cadena1=cadena1+"2";
                    txtJDisplay.setText(cadena1);}
                else{
                    cadena2=cadena2+"2";
                    txtJDisplay.setText(cadena2);}
                break;
            case R.id.Btn3:
                if (cambia==false){
                    cadena1=cadena1+"3";
                txtJDisplay.setText(cadena1);}
                else{
                    cadena2=cadena2+"3";
                txtJDisplay.setText(cadena2);}
                break;
            case R.id.BtnResta:
                if (Boperacion==false && cadena1!="")
                {
                cambia=true;
                soperacion="-";}
                else
                    Toast.makeText(getApplicationContext(),"Solo una operación",Toast.LENGTH_SHORT).show();
                break;
            case R.id.BtnPunto:
                if (punto==false) {
                    if (cambia = false){
                        cadena1 = cadena1 + ".";
                    txtJDisplay.setText(cadena1);}
                    else{
                        cadena2 = cadena2 + ".";
                    txtJDisplay.setText(cadena2);}
                }
                else
                //poner toast
                    Toast.makeText(getApplicationContext(),"Solo un punto en número",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Btn0:
                if (cambia=false){
                    cadena1=cadena1+"0";
                    txtJDisplay.setText(cadena1);}
                else{
                    cadena2=cadena2+"0";
                txtJDisplay.setText(cadena2);}
                break;
            case R.id.BtnResultado:
                if (cadena1!="" && cadena2!=""){
                Num1=Double.parseDouble(cadena1);
                Num2=Double.parseDouble(cadena2);
                if (soperacion=="+") nResultado=Num1+Num2;
                if (soperacion=="-") nResultado=Num1-Num2;
                if (soperacion=="*") nResultado=Num1-Num2;
                if (soperacion=="/") nResultado=Num1/Num2;
                String txtResultado= String.valueOf(nResultado);
                txtJDisplay.setText(txtResultado);}
                else
                    Toast.makeText(getApplicationContext(),"Se espera un numero",Toast.LENGTH_SHORT).show();
                break;
            case R.id.BtnSuma:
                if (Boperacion==false && cadena1!="")
                {
                cambia=true;
                soperacion="+";}
                else
                    Toast.makeText(getApplicationContext(),"Solo una operación, se espera un numero",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
