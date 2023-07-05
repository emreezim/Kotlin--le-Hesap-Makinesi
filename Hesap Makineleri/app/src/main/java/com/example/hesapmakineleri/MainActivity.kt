package com.example.hesapmakineleri

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val RQ_SPEECH_REC=102

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonses.setOnClickListener{
            askSpeechInput()

        }

}




    var sayi=0
var sayi1=""
    var sayi7=0
    var sayi9=0
    var sayiParantez=""
    var sayac=0
    var sayac2=0
    var sayi10=""
    var sayi11=""
    var sayi12=0
    var sayi13=0
    var sayac3=0
    var sayi14=0
    @SuppressLint("SuspiciousIndentation")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RQ_SPEECH_REC && resultCode == Activity.RESULT_OK){
            val result =data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)

            textView.text=result?.get(0).toString()





            }

        if (sayac2==0){
            sayac2++;
            sayi10=textView.text.toString()
            sayiText.text="$sayi10"

        }
        else if (sayac2==1){

            sayi11=textView.text.toString()

            if(sayi11=="artı"){
                sayiText.text="${sayiText.text}+"
                textView.text="+"
            }
           else if(sayi11=="eksi")
            {
                sayiText.text="${sayiText.text}-"
                textView.text="-"
            }
            else if(sayi11=="çarpı")
            {
                sayiText.text="${sayiText.text}*"
                textView.text="*"
            }
            else if(sayi11=="böl"){
                sayiText.text="${sayiText.text}/"
                textView.text="/"
            }
            sayac2++;
        }
      else{
          var sayi14=textView.text.toString()

            if(sayi11=="artı"){
                sayiText.text="${sayiText.text}$sayi14"
                sayi12=sayi10.toInt()
                sayi13=sayi14.toInt()
                textView.text=sayiText.text
                sayiText.text=(sayi12+sayi13).toString()
            }
            else if(sayi11=="eksi")
            {
                sayiText.text="${sayiText.text}$sayi14"
                sayi12=sayi10.toInt()
                sayi13=sayi14.toInt()
                textView.text=sayiText.text
                sayiText.text=(sayi12-sayi13).toString()
            }
            else if(sayi11=="çarpı")
            {
                sayiText.text="${sayiText.text}$sayi14"
                sayi12=sayi10.toInt()
                sayi13=sayi14.toInt()
                textView.text=sayiText.text
                sayiText.text=(sayi12*sayi13).toString()
            }
            else if(sayi11=="böl"){
                sayiText.text="${sayiText.text}$sayi14"
                sayi12=sayi10.toInt()
                sayi13=sayi14.toInt()
                textView.text=sayiText.text
                sayiText.text=((sayi12/sayi13).toDouble()).toString()
            }

          sayac2=0
      }
    }

    private fun askSpeechInput(){
        if(!SpeechRecognizer.isRecognitionAvailable(this)){
            Toast.makeText(this,"Speech recognition is not available",Toast.LENGTH_SHORT).show()
        }else{
            val i= Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            if (sayac3==0){
                i.putExtra(RecognizerIntent.EXTRA_PROMPT,"1.Sayıyı Söyleyiniz")
                sayac3++
            }
         else   if (sayac3==1){
                i.putExtra(RecognizerIntent.EXTRA_PROMPT,"İşlemi Söyleyiniz")
                sayac3++
            }
           else if(sayac3==2){
                i.putExtra(RecognizerIntent.EXTRA_PROMPT,"2.Sayıyı Söyleyiniz")
                sayac3=0
           }

            startActivityForResult(i,RQ_SPEECH_REC)

        }

    }

    fun buttonBir (view: View){
        var sayi0=1

        if (sayi7==3)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
        }
        if (sayi7 == 0)
        {
            sayiText.text="1"
            sayi7=3

        }
        if(sayi7==1)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
            sayi7=3
        }
        if(sayi7==2)
        {
            var sayi8=sayiText.text

            sayiText.text="$sayi8$sayi0"
            sayi7=3
        }

        sayi9=1

    }

    fun buttonIki (view: View){
        var sayi0=2
        if(sayi7==3)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
        }
        if (sayi7 == 0)
        {
            sayiText.text="2"
            sayi7=3
        }
        if(sayi7==1)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
            sayi7=3
        }
        if(sayi7==2)
        {
            var sayi8=sayiText.text
            sayiText.text=""
            sayiText.text="$sayi8$sayi0"
            sayi7=3
        }

        sayi9=2

    }

    fun buttonUc (view: View){
        var sayi0=3
        if(sayi7==3)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
        }
        if (sayi7 == 0)
        {
            sayiText.text="3"
            sayi7=3
        }
        if(sayi7==1)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
            sayi7=3
        }
        if(sayi7==2)
        {
            var sayi8=sayiText.text
            sayiText.text=""
            sayiText.text="$sayi8$sayi0"
            sayi7=3
        }
        sayi9=3

    }

    fun buttonDort (view: View){
        var sayi0=4
        if(sayi7==3)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
        }
        if (sayi7 == 0)
        {
            sayiText.text="4"
            sayi7=3
        }
        if(sayi7==1)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
            sayi7=3
        }
        if(sayi7==2)
        {
            var sayi8=sayiText.text
            sayiText.text=""
            sayiText.text="$sayi8$sayi0"
            sayi7=3
        }

        sayi9=4

    }

    fun buttonBes (view: View){
        var sayi0=5
        if(sayi7==3)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
        }
        if (sayi7 == 0)
        {
            sayiText.text="5"
            sayi7=3
        }
        if(sayi7==1)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
            sayi7=3
        }
        if(sayi7==2)
        {
            var sayi8=sayiText.text
            sayiText.text=""
            sayiText.text="$sayi8$sayi0"
            sayi7=3
        }

        sayi9=5

    }

    fun buttonAlti (view: View){
        var sayi0=6
        if(sayi7==3)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
        }
        if (sayi7 == 0)
        {
            sayiText.text="6"
            sayi7=3
        }
        if(sayi7==1)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
            sayi7=3
        }
        if(sayi7==2)
        {
            var sayi8=sayiText.text
            sayiText.text=""
            sayiText.text="$sayi8$sayi0"
            sayi7=3
        }
        sayi9=6

    }

    fun buttonYedi (view: View){
        var sayi0=7
        if(sayi7==3)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
        }
        if (sayi7 == 0)
        {
            sayiText.text="7"
            sayi7=3
        }
        if(sayi7==1)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
            sayi7=3
        }
        if(sayi7==2)
        {
            var sayi8=sayiText.text
            sayiText.text=""
            sayiText.text="$sayi8$sayi0"
            sayi7=3
        }
        sayi9=7

    }

    fun buttonSekiz (view: View){
        var sayi0=8
        if(sayi7==3)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
        }
        if (sayi7 == 0)
        {
            sayiText.text="8"
            sayi7=3
        }
        if(sayi7==1)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
            sayi7=3
        }
        if(sayi7==2)
        {
            var sayi8=sayiText.text
            sayiText.text=""
            sayiText.text="$sayi8$sayi0"
            sayi7=3
        }
        sayi9=8
    }

    fun buttonDokuz (view: View){
        var sayi0=9
        if (sayi7==3)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
        }
        if (sayi7 == 0)
        {
            sayiText.text="9"
            sayi7=3
        }
        if(sayi7==1)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
            sayi7=3
        }
        if(sayi7==2)
        {
            var sayi8=sayiText.text
            sayiText.text=""
            sayiText.text="$sayi8$sayi0"
            sayi7=3
        }
        sayi9=9

    }

    fun buttonSifir (view: View){
        var sayi0=0
        if (sayi7==3)
        {
            var yazi1=sayiText.text
            sayiText.text="$yazi1$sayi0"
        }
        if (sayi7 == 0)
        {
            sayiText.text="0"
            sayi7=3
        }
        if(sayi7==2)
        {
            var sayi8=sayiText.text
            sayiText.text=""
            sayiText.text="$sayi8$sayi0"
            sayi7=3
        }
        sayi9=10

    }

    fun buttonSil (view: View){
        sayiText.text=""
        textView.text=""
    }

    fun buttonCikart (view: View){
        textView.text=""
         sayi1=sayiText.text.toString()
        textView.text="$sayi1-"
        sayi=1
    }

    fun buttonTopla (view: View){
        textView.text=""
        sayi1 = sayiText.text.toString()
        textView.text="$sayi1+"
        sayiText.text=""
        sayi=0
    }

    fun buttonPozNeg (view: View){
        sayiText.text="-"
        sayi7=1
    }

    fun buttonVirgul (view: View){
        sayi7=2
        var yazilar=sayiText.text
        if (sayi9==1)
        {
            sayiText.text="$yazilar."
        }
        if (sayi9==2)
        {
            sayiText.text="$yazilar."
        }
        if (sayi9==3)
        {
            sayiText.text="$yazilar."
        }
        if (sayi9==4)
        {
            sayiText.text="$yazilar."
        }
        if (sayi9==5)
        {
            sayiText.text="$yazilar."
        }
        if (sayi9==6)
        {
            sayiText.text="$yazilar."
        }
        if (sayi9==7)
        {
            sayiText.text="$yazilar."
        }
        if (sayi9==8)
        {
            sayiText.text="$yazilar."
        }
        if (sayi9==9)
        {
            sayiText.text="$yazilar."
        }
        if (sayi9==10)
        {
            sayiText.text="$yazilar."
        }


    }

    fun buttonEsit (view: View){


        var sayi2=sayiText.text
        var yazi=textView.text
        textView.text="$yazi $sayi2"
        if (sayac==1)
        {
            sayi1=sayiParantez.toString()
        }
        var sayi4=sayi1.toDouble()
        var sayi3=sayi2.toString().toDouble()

        if (sayi==0){
            var sayi5=sayi4
            var sayi6=sayi3
            sayiText.text=(sayi5 + sayi6).toString()

        }
      else if (sayi==1)
        {
            var sayi5=sayi4
            var sayi6=sayi3
            sayiText.text=(sayi5 - sayi6).toString()

        }
     else if (sayi==2)
        {
            var sayi5=sayi4
            var sayi6=sayi3
            sayiText.text=(sayi5 % sayi6).toString()

        }
     else if (sayi==3)
        {
         var sayi5=sayi4
            var sayi6=sayi3
            sayiText.text=(sayi5 / sayi6).toString()

        }
       else if (sayi==4)
        {
            var sayi5=sayi4
            var sayi6=sayi3
            sayiText.text=(sayi5 * sayi6).toString()

        }

    }

    fun buttonMod (view: View){
        textView.text=""
        sayi1=sayiText.text.toString()
        textView.text="$sayi1 %"
        sayiText.text=""
        sayi=2
    }

    fun buttonBol (view: View){
        textView.text=""
        sayi1=sayiText.text.toString()
        textView.text="$sayi1 /"
        sayiText.text=""
        sayi=3
    }

    fun buttonCarp (view: View){
        textView.text=""
        sayi1=sayiText.text.toString()
        textView.text="$sayi1 *"
        sayiText.text=""
        sayi=4
    }

    fun buttonParantez (view: View){
        var parantezyazi=textView.text
        sayiParantez=sayiText.text.toString()
        sayiText.text=""
        sayiText.text="($parantezyazi)"
        sayac=1
    }

}