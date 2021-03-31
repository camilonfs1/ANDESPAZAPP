package com.andes.andespazapp.View.Learn.Reconciliation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Learn.Memory.Receibe_activity
import kotlinx.android.synthetic.main.activity_.*

class ActivityReconciliation : AppCompatActivity() {
    private var Cardact1 : CardView? =null
    private var Cardact2 : CardView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reconciliation)

        Cardact1 = act1
        Cardact2 = act2
        Cardact1!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","Reconciliacion")
            intent.putExtra("Text", "1 ¿de qué manera se puede mirar que una víctima hace parte del acoso escolar?\n\n2 ¿según el cortometraje acerca del acoso escolar, como te ves reflejado dentro de él, o que participante eres dentro de dicho cortometraje?\n\n3. En cuanto a las imágenes mostradas en tipos de violencia familiar y escolar, destinado a describir lo que cada imagen te hace ver allí ")
            this.startActivity(intent)
        }
        Cardact2!!.setOnClickListener {
            var intent = Intent(this, Receibe_activity::class.java)
            intent.putExtra("title","Actividad didáctica:")
            intent.putExtra("Text", "En una hoja van a anotar todo tipo de ofensas con las que nos hayan llegado a afectar alguna vez, explicar la importancia del perdón y la reconciliación acerca del tema que ya se vio anteriormente, deja que por medio de todo lo que les causa ira y dolor rompa el papel en muchos pedazos y se desahoguen, por último, gritar yo te perdono apenas tengas el papel completamente destrozado")
            this.startActivity(intent)

        }
    }
}