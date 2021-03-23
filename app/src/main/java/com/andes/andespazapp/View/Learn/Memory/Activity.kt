package com.andes.andespazapp.View.Learn.Memory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_.*

class Activity : AppCompatActivity() {
    private var Cardact1 : CardView? =null
    private var Cardact2 : CardView? =null
    private var Cardact3 : CardView? =null
    private var Cardact4 : CardView? =null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_)
        Cardact1 = act1
        Cardact2 = act2
        Cardact3 = act3
        Cardact4 = act4

        Cardact1!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","Hagamos memoria")
            intent.putExtra("Text", "En un espacio al aire libre se hará un círculo en" +
                    " el cual cada persona se presentara y tendrá que responder las siguientes " +
                    "preguntas: ¿Quién es?, ¿En qué lugar de Colombia vive?, Nombre algún" +
                    "suceso de violencia que haya ocurrido en el territorio en el que vive. Si el" +
                    "suceso es nombrado por varias personas del grupo o los demás tienen " +
                    "conocimiento de este, se hará una reflexión del por qué lo conocen, centrando la" +
                    "reflexión en el por qué está en su memoria ya sea porque fue un suceso que les " +
                    "genero tristeza, diferentes opiniones, lo presenció, etc, y por qué es necesario " +
                    "alimentar la memoria así se encuentre dolorosa con miradas de paz, verdad y " +
                    "reconciliación.\n\n")
            this.startActivity(intent)


        }
        Cardact2!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","La corototeca")
            intent.putExtra("Text", "Para esta dinámica cada persona deberá llevar un " +
                    "objeto que tenga un significado individual especial, en el espacio que se " +
                    "encuentren deberán hacer mesa redonda y poner una mesa en el centro, la " +
                    "actividad se realizará con objetos o “corotos”. Se les anunciará a los/a " +
                    "participantes que esta se va a convertir en un lugar sagrado: en un museo de la " +
                    "memoria, que va a acoger los objetos significativos que cada uno/a ha traído." +
                    "Luego, cada uno/a va pasar a la mesa, sin decir nada, a dejar su objeto. Luego, " +
                    "se le pedirá a cada uno/a que tome con gran cuidado uno de los objetos y " +
                    "comparta con el grupo por qué cree que este reviste especial importancia para " +
                    "quien lo trajo. Enseguida, la persona que lo trajo puede comentar o " +
                    "complementar las razones que hacen de su objeto algo significativo. Al final se " +
                    "preguntará qué les evoca la actividad y reflexionaran sobre la relación, de los " +
                    "dispositivos materiales y la activación de la memoria. Estos nos permiten " +
                    "recorrer caminos ya vividos, volver a nuestros lugares significativos mediante la " +
                    "imaginación, recordar personas importantes en nuestras vidas y conectarnos con " +
                    "los demás por medio de sus memorias e historias. Es un acercamiento " +
                    "emocional y afectivo que también nos habla de las trayectorias y contextos de " +
                    "las diversas experiencias de los/a demás.\n\n")
            this.startActivity(intent)

        }
        Cardact3!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","Cardumen")
            intent.putExtra("Text", "(Concentración grande de peces, generalmente de la misma especie," +
                    "que se desplazan juntos). Para esta actividad es necesario contar con un sitio " +
                    "despejado para caminar por él sin obstáculos. El profesor dará las siguientes " +
                    "indicaciones: primero, que los participantes caminen alrededor del espacio, " +
                    "evitando el círculo y haciendo contacto visual con las otras personas; luego, que, " +
                    "al oír su aplauso, se congelen y queden como estatuas y al volver a oír otro " +
                    "aplauso, retomen el movimiento. Se deberá recordarles evitar el círculo y hacer " +
                    "contacto visual. Continuar haciendo ejercicios por el estilo que parezcan" +
                    "interesantes (puede cambiar la instrucción: al oír su aplauso pueden abrazar a" +
                    "su compañero/a más cercano/a o saludar de manera eufórica). \n" +
                    "\nDespués de unos" +
                    "minutos,pídales que se conecten como un cardumen. Es decir, cuando" +
                    "cualquiera de ellos o ellas pare, todos/a deben quedarse como estatuas. Así" +
                    "mismo, cualquier compañera o compañero puede continuar caminando y todos" +
                    "deben seguir su iniciativa. Con este juego se busca que los y las participantes" +
                    "sean conscientes de cómo sus movimientos afectan a los demás. El recorrido" +
                    "por la memoria histórica incorpora al cuerpo e incluye también nuestras" +
                    "emociones. No es un viaje cualquiera.\n\n")
            this.startActivity(intent)

        }
        Cardact4!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","Reflexión")
            intent.putExtra("Text", "La memoria histórica como un arma poderosa para caminar hacia una sociedad " +
                    "unida y en paz que reconozca el pasado y sus fuertes impactos en el país, en los " +
                    "territorios y en su gente. La tarea como jóvenes es acudir a la memoria por " +
                    "diversos motivos, para conocer la verdad, aportar a la dignificación de las " +
                    "víctimas, también porque es fuente de sensibilización necesaria para la sociedad " +
                    "colombiana, su función va de la mano con la historia y sus aprendizajes para no " +
                    "cometer errores pasados y trabajar en comunidad por un país mejor, porque" +
                    "para la guerra nada!.\n\n")
            this.startActivity(intent)

        }

    }
}