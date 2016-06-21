package mx.unam.jigm.practica1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActividadPrincipal extends AppCompatActivity implements View.OnClickListener{
   //variables para hacer las operaciones
    Double Num1,Num2,nResultado;
    //para poner el resultado
     TextView txtJDisplay;
    //para poner primer numero y operación
    TextView txtJDisplay1,txtJDisplay2,ModoCalculator;
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
   //para operacion binaria
    Boolean bBinario=false;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        //preparan textview
        txtJDisplay=(TextView) findViewById(R.id.TxtDisplay);
        txtJDisplay1=(TextView) findViewById(R.id.TxtDisplay1);
        txtJDisplay2=(TextView) findViewById(R.id.TxtDisplay2);
        ModoCalculator=(TextView) findViewById(R.id.TextModoCalculadora);
        //se preparan los botones para escuchar el onclick
        findViewById(R.id.BtnDel).setOnClickListener(this);
        findViewById(R.id.BtnMod).setOnClickListener(this);
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
        findViewById(R.id.BtnDecimal).setOnClickListener(this);
        findViewById(R.id.BtnBinario).setOnClickListener(this);
    }
    // accion del onclick de los botones
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnBinario:
               pBina();
                break;
            case R.id.BtnDecimal:
                pDecimal();
                break;
            case R.id.BtnDel:
                Pdelete();
                break;
            case R.id.BtnMod:
                operacion("%");
                break;
            case R.id.BtnBorrar:
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
               Ppunto();
                break;
            case R.id.Btn0:
                CadenaNumero("0");
                break;
            case R.id.BtnResultado:
                pResultado();
                break;
            case R.id.BtnSuma:
                operacion("+");
                break;
        }
    }
    //para ir concatenando numero en operadores
    private void CadenaNumero(String StrNumero)
    {
        if (cambia==false){
            if (cadena1=="0") {cadena1="";}
            cadena1=cadena1+StrNumero;
            txtJDisplay.setText(cadena1);
            txtJDisplay1.setText(cadena1);
        }
        else{
            if (cadena2=="0") {cadena2="";}
            cadena2=cadena2+StrNumero;
            txtJDisplay.setText(cadena2);
        }
    }
    //para preparar los botones para suma decimal
    private void pDecimal()
    {
        limpia(1);
        findViewById(R.id.Btn2).setEnabled(true);
        findViewById(R.id.Btn3).setEnabled(true);
        findViewById(R.id.Btn4).setEnabled(true);
        findViewById(R.id.Btn5).setEnabled(true);
        findViewById(R.id.Btn5).setEnabled(true);
        findViewById(R.id.Btn6).setEnabled(true);
        findViewById(R.id.Btn7).setEnabled(true);
        findViewById(R.id.Btn8).setEnabled(true);
        findViewById(R.id.Btn9).setEnabled(true);
        findViewById(R.id.BtnMultiplica).setEnabled(true);
        findViewById(R.id.BtnDivision).setEnabled(true);
        findViewById(R.id.BtnResta).setEnabled(true);
        findViewById(R.id.BtnMod).setEnabled(true);
        findViewById(R.id.BtnPunto).setEnabled(true);
        bBinario=false;
        ModoCalculator.setText(R.string.ModeOperationDec);
        Toast.makeText(getApplicationContext(), R.string.ModeOperationDec,Toast.LENGTH_SHORT).show();
    }
    //para preparar los botones para suma binaria
    private void pBina(){
        limpia(1);
        findViewById(R.id.Btn2).setEnabled(false);
        findViewById(R.id.Btn3).setEnabled(false);
        findViewById(R.id.Btn4).setEnabled(false);
        findViewById(R.id.Btn5).setEnabled(false);
        findViewById(R.id.Btn5).setEnabled(false);
        findViewById(R.id.Btn6).setEnabled(false);
        findViewById(R.id.Btn7).setEnabled(false);
        findViewById(R.id.Btn8).setEnabled(false);
        findViewById(R.id.Btn9).setEnabled(false);
        findViewById(R.id.BtnMultiplica).setEnabled(false);
        findViewById(R.id.BtnDivision).setEnabled(false);
        findViewById(R.id.BtnResta).setEnabled(false);
        findViewById(R.id.BtnMod).setEnabled(false);
        findViewById(R.id.BtnPunto).setEnabled(false);
        bBinario=true;
        ModoCalculator.setText(R.string.ModeTextOpBinary);
        Toast.makeText(getApplicationContext(), R.string.ModeOperationBin,Toast.LENGTH_SHORT).show();
    }
    //para inicializar variables en calculadora
    private void limpia(int nLimpiaDisplay){
        cambia=false;
        cadena1="";
        cadena2="";
        Boperacion=false;
        punto=false;
        if (nLimpiaDisplay==1){
            txtJDisplay.setText("0");
            txtJDisplay1.setText("");
        }
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
            case "%":
                soperacion="%";
                break;
        }
        if (Boperacion==false)
        { if (cadena1!=""){
            cambia=true;
            Boperacion=true;
            punto=false;
            txtJDisplay2.setText(soperacion);
        }
        else
            Toast.makeText(getApplicationContext(), R.string.element_number,Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),R.string.element_operador,Toast.LENGTH_SHORT).show();

    }

    private void puntocadena(String cadenainterna){
        if (cadenainterna.substring(cadenainterna.length()-1).equals(".")){
            punto=false;
        }
    }
    //proc para el delete
    private void Pdelete()
    {
        if (cambia == false)
        {
            if (cadena1.length()>1){
                puntocadena(cadena1);
                String Subcadena1=cadena1.substring(0,cadena1.length()-1);
                cadena1 = Subcadena1;
                txtJDisplay.setText(cadena1);
                txtJDisplay1.setText(cadena1);}
            else
                {cadena1 = "0";
                limpia(1);}
        }
        else
        {
            if (cadena2.length() > 1)
                {
                puntocadena(cadena2);
                String Subcadena2 = cadena2.substring(0, cadena2.length() - 1);
                cadena2 = Subcadena2;
                }
            else {
                cadena2 = "0";
                limpia(1);
                 }
            txtJDisplay.setText(cadena2);
        }
    }
    //para el resultado al oprimir el boton de igual
    private void pResultado(){
        String txtResultado="";
        if (cadena1!="" && cadena2!="" && soperacion!="" ){
            Num1=Double.parseDouble(cadena1);
            Num2=Double.parseDouble(cadena2);
            if (soperacion=="+")
            {
                if (bBinario==false)
                {nResultado=Num1+Num2;}
                else
                {
                    //operacion suma en binario
                    Integer bNum1 = Integer.parseInt(cadena1, 2);
                    Integer bNum2 = Integer.parseInt(cadena2, 2);
                    Integer bRes = bNum1+ bNum2;
                    txtResultado =   Integer.toString(bRes,2);
                }
            }
            if (soperacion=="-") nResultado=Num1-Num2;
            if (soperacion=="*") nResultado=Num1*Num2;
            if (soperacion=="/") {
                if (Num2>0)
                {nResultado=Num1/Num2;}
                else
                {Toast.makeText(getApplicationContext(),R.string.element_division,Toast.LENGTH_SHORT).show();}}
            if (soperacion=="%") nResultado=Num1%Num2;
            if (bBinario==false){
            txtResultado= String.valueOf(nResultado);}
            txtJDisplay.setText(txtResultado);
            txtJDisplay1.setText("");
            txtJDisplay2.setText("");
            limpia(0);
        }
        else
            Toast.makeText(getApplicationContext(),R.string.element_operacion,Toast.LENGTH_SHORT).show();
    }
    //para agregar punto a las cadenas de numeros
    private void Ppunto(){
        if (punto==false) {
            if (cambia == false){
                cadena1 = cadena1 + ".";
                txtJDisplay.setText(cadena1);
            }
            else{
                cadena2 = cadena2 + ".";
                txtJDisplay.setText(cadena2);}
        }
        else
            Toast.makeText(getApplicationContext(),R.string.element_punto,Toast.LENGTH_SHORT).show();
        punto=true;
    }

}


