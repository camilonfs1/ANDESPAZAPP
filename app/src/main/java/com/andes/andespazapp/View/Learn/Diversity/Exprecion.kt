package com.andes.andespazapp.View.Learn.Diversity

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.activity_exprecion.*

class Exprecion : AppCompatActivity() {

    private var card_lebianas:CardView?=null
    private var card_Gay:CardView?=null
    private var card_Bisexualidad:CardView?=null
    private var card_Transgénero:CardView?=null
    private var card_Agenero:CardView?=null
    private var card_pangénero:CardView?=null
    private var card_bigenero:CardView?=null
    private var card_transexuales:CardView?=null
    private var card_travestis:CardView?=null
    private var card_Asexualidad:CardView?=null
    private var card_grissexuald:CardView?=null
    private var card_Demisexual:CardView?=null
    private var card_Intersexuales:CardView?=null
    private var card_Lithsexual:CardView?=null
    private var card_Sapiosexual:CardView?=null
    private var card_Skoliosexual:CardView?=null
    private var card_Polisexual:CardView?=null
    private var card_Autosexual:CardView?=null
    private var card_HomoQueers:CardView?=null
    private var card_Queers:CardView?=null

    private var myDialog0: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exprecion)

        myDialog0 = Dialog(this)

        card_lebianas= Lesbianas
        card_Gay=gay
        card_Bisexualidad= bisexualidad
        card_Transgénero= transegenero
        card_Agenero= agenero
        card_pangénero= pangenero
        card_bigenero= bigenero
        card_travestis= travesti
        card_Asexualidad= asexualidad
        card_grissexuald=grissexual
        card_Demisexual=demisexual
        card_Intersexuales=intersexual
        card_Lithsexual=lighsexual
        card_Sapiosexual=sapiosexual
        card_Skoliosexual=skoliosexual
        card_Polisexual=polisexual
        card_Autosexual=autosexual
        card_HomoQueers=homoqueer
        card_Queers=queer

        card_lebianas!!.setOnClickListener {
            showPopUp("Lesbianas: Son aquellas mujeres que se sienten atraídas por el mismo sexo, es la atracción afectiva, sexual, la identidad de estas mujeres sigue siendo femenina diferenciándose su gusto por el mismo sexo, muchas mujeres adoptan ser más masculinas en sus actitudes en esta cuestión varían.\n" +
                    "Es considerada la bandera del orgullo lésbico, creada hacia el año 2011, creada por Mercedes Diaz Rodríguez, andera que simboliza fuertemente al genero feminista\n")
        }
        card_Gay!!.setOnClickListener {
            showPopUp(" Gay: Son aquellos hombres que se sienten atraídos por el mismo sexo, es la atracción afectiva exual, la identidad de estos hombres sigue siendo masculina diferenciándose su gusto por el mismo sexo, muchos hombres adoptan ser más femeninos en sus actitudes en esta cuestión varían.\n" +
                    "Es considerada la bandera del orgullo gay y surgió en 1978, su creador es Gilbert Baker, el color rojo significa la vida, el color naranja significa salud, el amarillo significa la luz solar, el verde la naturaleza, el color azul la serenidad, y por último el morado espíritu.")
        }
        card_Bisexualidad!!.setOnClickListener {
            showPopUp("Bisexualidad: Atracción por ambos sexos, aquí se encuentran hombres y mujeres no muestran su preferencia marcada por uno u otro sexo al momento de elegir a una pareja.\n" +
                    "Es considerada la bandera del orgullo bisexual, surgió en 1998, por Maicol Peach, el color morado significa la atracción hacia el mismo sexo, color central significa la atracción hacia ambos sexos, el color azul significa la atracción hacia el sexo opuesto.\n")
        }
        card_Transgénero!!.setOnClickListener {
            showPopUp("Transgénero: La identidad del género de las personas no concuerda con el sexo biológico, la diferencia con las personas transexuales es que estas personas ignoran por completo el rechazo que se les tienen y viven sin la finalidad de practicarse operaciones quirúrgicas. Dentro de este grupo entran los:\n" +
                    "Es considerada la bandera del orgullo transgénero, por Mónica Hellms, aquí se encuentran los colores tradicionales con los que se visten a los niños y las niñas, rosa para las niñas, azul para los niños,el color blanco simboliza a las personas que se encuentran en su transición como lo son las personas transgéneros")
        }
        card_Agenero!!.setOnClickListener {
            showPopUp("Agenero: Es aquella persona que no se siente identificada por ningún género, la identidad por la que se identifica estas personas es nula completamente.\n")
        }
        card_pangénero!!.setOnClickListener {
            showPopUp("Pangénero: Se considera a la persona que es de todos los géneros \n" +
                    "Es considerada la bandera del orgullo pansexual, creada en el año 2010, el color rosa representa a las mujeres, el amarillo representa a las personas que no tiene genero binario, y el color azul simboliza a los hombres.\n")
        }
        card_bigenero!!.setOnClickListener {
            showPopUp("Bigenero: Se considera de los dos sexos ")
        }
        card_travestis!!.setOnClickListener {
            showPopUp("Travestis: Persona que se viste y se maquilla como si fuera del sexo opuesto")
        }
        card_Asexualidad!!.setOnClickListener {
            showPopUp("Asexualidad: No sienten atracción física ni sexual por ninguna persona\n" +
                    "Es considerada la bandera del orgullo asexual, el color negro representa la asexualidad, el color gris representa la sexualidad es decir la zona gris del sexo.\n")
        }
        card_grissexuald!!.setOnClickListener {
            showPopUp("Gra y sexual o gris sexual: Son aquellas personas que se encuentran entre la asexualidad y la sexualidad, es la conexión de estas dos las personas que aquí se encuentran pueden llegar a sentirse (heterosexuales, gay, lesbiana, etc.)")
        }
        card_Demisexual!!.setOnClickListener {
            showPopUp("Demisexual: No genera atracción sexual alguna \n" +
                    " consiste en el triangulo negro y tres franjas horizontales demostrando por medio de un vinculo tan solo romantico con una persona.\n")
        }
        card_Intersexuales!!.setOnClickListener {
            showPopUp("Intersexuales: Ahora que sabes que es un hombre y una mujer, es importante hablar sobre este tipo de personas, siendo esta aquella persona que nace con una combinación de características biológicas tanto masculinas como femeninas, este tipo de características biológicas hacen que sea difícil saber si es hombre o mujer, aquí no tiene que ver con la cuestión de querer ser, si no con la cuestión de lo que el estado físico de cada persona muestra ser.\n" +
                    "Lo que hace que entren en inconvenientes muchas veces los mismos médicos al ver que tienen más desarrollado por ejemplo los genitales masculinos, pero al momento de ver sus hormonas son completamente femeninas entrando en un desbalance.\n" +
                    "Es considerada la bandera del orgullo intersexual, creada en el año 2013, creada por la organización intersexual australiana, se deciden utilizar color amarillo con purpura ya que son considerados colores que no tienen género, el circulo es una \n")
        }
        card_Lithsexual!!.setOnClickListener {
            showPopUp("Lithsexual: Las personas de este tipo tienen atracción hacia otras personas, pero no necesariamente son correspondidas de la misma forma simplemente están y ya, no recibe sentimientos de forma recíproca ")
        }
        card_Sapiosexual!!.setOnClickListener {
            showPopUp("Sapiosexual: Se sienten atraídos por la inteligencia de una persona su vínculo exclusivamente es intelectual.")
        }
        card_Skoliosexual!!.setOnClickListener {
            showPopUp("Skoliosexual: tendencia sexual orientada a géneros no binarios, se sienten atraídos por personas transgénero y también las personas Inter genero le atraen las personas que no son sin género, en las que la identidad de genero y el genero asignados al nacer coinciden ")
        }
        card_Polisexual!!.setOnClickListener {
            showPopUp("Polisexual: Hace referencia a la atracción también al igual que el pansexual el gusto por todos los géneros, pero se diferencia a que a unos le atrae más que otros géneros.\n" +
                    "Es considerada la bandera del orgullo polisexual, el rosa es la atracción hacia las mujeres, el color verde es la atracción hacia personas de dos o más géneros y el color azul es la atracción hacia los hombres.\n")
        }
        card_Autosexual!!.setOnClickListener {
            showPopUp("Autosexual: Atracción y amor hacia uno mismo, los autosexuales también tienen tendencia a ser asexuales.")
        }
        card_HomoQueers!!.setOnClickListener {
            showPopUp("Heterosexual: atracción hacia las personas del sexo opuesto es la mayoría")
        }
        card_Queers!!.setOnClickListener {
            showPopUp("Queers: Describe una identidad de género y sexual distinta a la heterosexual, cambian con el tiempo no encajan ordenadamente en una identidad o la otra como ser (hombre, mujer, gay o hetero) \n" +
                    "Es considerada la bandera del orgullo queers, su creador es Marilyn Roxie, el color lavanda es una mezcla del color rosa y azul que bien sabemos que cada uno representa a los hombres y las mujeres y la mezcla de juntos representa en orgullo queers, el color blanco lo representa el género neutro, el color verde representa a las personas del tercer género.\n")
        }
    }
    private fun showPopUp(text1: String) {
        myDialog0!!.setContentView(R.layout.popupthreep_mini)
        var close: TextView = myDialog0!!.findViewById(R.id.txtClose)
        var text: TextView = myDialog0!!.findViewById(R.id.text)

        text.setText(text1)

        close.setOnClickListener {
            myDialog0!!.dismiss()
        }
        myDialog0!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog0!!.show()
    }
}