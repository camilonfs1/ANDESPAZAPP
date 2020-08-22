package com.andes.andespazapp.ViewModel.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.andes.andespazapp.Model.Learn_Item
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.LearnViewModel
import org.w3c.dom.Text
import java.util.logging.Handler


class AdapterViewPager_Learn (context: Context): PagerAdapter()   {
    private var models: ArrayList<Learn_Item>? = null
    private var context: Context? = null
    private var roll: String? = null
    private var isStarted = false
    private var progressStatus = 0
    private var handler: Handler? = null
    private var LearnViewModel = LearnViewModel()

    init {
        this.models = LearnViewModel.read()
        this.context = context
        this.roll = roll
    }

    override fun isViewFromObject(view: View, objecto: Any): Boolean {
        return view.equals(objecto)
    }

    override fun getCount(): Int {
        return models!!.size
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(context).inflate(R.layout.item_view_pager_learn, container, false)


        var image: ImageView = view.findViewById(R.id.image)
        var title: TextView = view.findViewById(R.id.title)
        var desc: TextView = view.findViewById(R.id.desc)
        var btn: Button = view.findViewById(R.id.btnmas)
        var text: TextView = view.findViewById(R.id.textViewHorizontalProgress)
        var bar: ProgressBar = view.findViewById(R.id.progressBarHorizontal)

//      image.setImageResource(models!!.get(position).image!!)
        title.setText(models!!.get(position).name)
        desc.setText(models!!.get(position).description)
        bar.progress = models!!.get(position).advance!!
        text.setText(models!!.get(position).advance!!.toString()+"/100")

        container.addView(view)
        return view
    }
    override fun destroyItem(container: ViewGroup, position: Int, objecto: Any) {
        container.removeView(objecto as View)
    }
    fun horizontalDeterminate(view: View) {
        isStarted = !isStarted
    }
}