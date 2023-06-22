package com.bachersoftltd.starsworstest.View

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.Log.e
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bachersoftltd.starsworstest.Data.CONST.BASE_URL
import com.bachersoftltd.starsworstest.Data.People.DataApiPeople
import com.bachersoftltd.starsworstest.Data.People.DataPeople
import com.bachersoftltd.starsworstest.Data.Planets.DataApiPlanets
import com.bachersoftltd.starsworstest.Data.Planets.DataPlanets
import com.bachersoftltd.starsworstest.Data.Starships.DataApiStartships
import com.bachersoftltd.starsworstest.Data.Starships.DataStarships
import com.bachersoftltd.starsworstest.R
import com.bachersoftltd.starsworstest.ViewModel.Adapters.AdapterStarWars
import com.bachersoftltd.starsworstest.ViewModel.CallBack.People.CallBackRequestPeople
import com.bachersoftltd.starsworstest.ViewModel.CallBack.Planets.CallBackRequestPlanets
import com.bachersoftltd.starsworstest.ViewModel.CallBack.Starships.CallBackRequestStarships
import com.bachersoftltd.starsworstest.ViewModel.Service.ServicePeople
import com.bachersoftltd.starsworstest.ViewModel.Service.ServicePlatets
import com.bachersoftltd.starsworstest.ViewModel.Service.ServiceStarships
import io.reactivex.plugins.RxJavaPlugins
import java.util.*
import kotlin.Throwable as Throwable


class MainActivity : AppCompatActivity(), CallBackRequestPlanets,CallBackRequestPeople,CallBackRequestStarships {

    lateinit var ed_search : SearchView
    lateinit var progres : ProgressBar
    lateinit var imageView : ImageView
    lateinit var im_favorite : ImageView
    lateinit var rc_view : RecyclerView
    lateinit var ll_view : LinearLayout
    val resrClientApiPlanets = ServicePlatets()
    val restClientApiPeople = ServicePeople()
    val restClientStarships = ServiceStarships()

    private var dataPlanets: ArrayList<DataPlanets>? = null
    private var dataPeople: ArrayList<DataPeople>? = null
    private var dataStarships: ArrayList<DataStarships>? = null
    private var myAdapter: AdapterStarWars? = null

    var flag1 = false
    var flag2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setId()
        setClick()
        setAnim()














    }

    private fun setAnim() {
        ll_view.setAlpha(0f)
        ll_view.animate().alpha(1f).setDuration(1300)
    }

    private fun setClick() {
        ed_search.setOnQueryTextListener(object :SearchView.    OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false

            }
            override  fun onQueryTextChange(newText: String?): Boolean {

                Log.e("Search","--> " + newText)

                if(flag1){
                    myAdapter?.filter?.filter(newText)
                }
                if (!flag2){
                    if (newText!!.length >= 2){
                        startApi()


                    }
                }

                return true
            }
        })





        im_favorite.setOnClickListener{
            startActivity(Intent(this,FavoriteActivity::class.java))

        }

    }

    private fun setId() {

        flag1 = false
        ed_search = findViewById(R.id.ed_search)
        progres = findViewById(R.id.progres)
        imageView = findViewById(R.id.imageView)
        im_favorite = findViewById(R.id.im_favorite)
        rc_view = findViewById(R.id.rc_view)
        ll_view = findViewById(R.id.ll_view)


    }

    override fun onBackPressed() {

    }
    override fun onDestroy() {
        super.onDestroy()
        resrClientApiPlanets.clear()
        restClientApiPeople.clear()
        restClientStarships.clear()
    }



    fun startApi() {
        flag2 = true
        progres.visibility = View.VISIBLE
        resrClientApiPlanets.execute(BASE_URL,this)
        restClientApiPeople.execute(BASE_URL,this)
        restClientStarships.execute(BASE_URL,this)





    }

    override fun successReq(response: DataApiPlanets?) {
        Log.e("Response",response.toString())
        flag1 = true

        dataPlanets = response?.resultsPlanets



        progres.visibility = View.GONE
        imageView.visibility = View.GONE
        rc_view.visibility = View.VISIBLE
        myAdapter = dataStarships?.let { dataPeople?.let { it1 -> AdapterStarWars(it, it1) } }
        rc_view.adapter = myAdapter
        myAdapter?.notifyDataSetChanged()





    }

    override fun successReq(response: DataApiPeople?) {
        dataPeople = response?.resultsPeople
        myAdapter = dataStarships?.let { dataPeople?.let { it1 -> AdapterStarWars(it, it1) } }
        rc_view.adapter = myAdapter
        myAdapter?.notifyDataSetChanged()
    }

    override fun successReq(response: DataApiStartships?) {
        dataStarships = response?.resultStarships
        Log.e("DATA","-->" + dataStarships)
        Log.e("DATA","-->" + dataPeople)
        myAdapter = dataStarships?.let { dataPeople?.let { it1 -> AdapterStarWars(it, it1) } }
        rc_view.adapter = myAdapter
        myAdapter?.notifyDataSetChanged()




    }



    override fun errorReq(error: String?) {

        Toast.makeText(this,"Error",Toast.LENGTH_SHORT)

    }
}