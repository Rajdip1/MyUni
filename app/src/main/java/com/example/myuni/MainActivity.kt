package com.example.myuni

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {

    private lateinit var universityList : ArrayList<UniversityInfo>
    private lateinit var myRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        var universityImgArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11
        )
        var universityNameArray = arrayOf(
            "University of Arizona",
            "University of Florida",
            "New York University",
            "University of Michigan",
            "University of Calgary",
            "University of California, Los Angeles",
            "University of Illinois, Chicago",
            "University of Illinois, Chicago, Champaign county",
            "The University of Texus at Austin",
            "The University of North Carolina at Charlotte",
            "University of Windsor"
        )

        val universityDetails = arrayOf(
            getString(R.string.university_detail1),
            getString(R.string.university_detail2),
            getString(R.string.university_detail3),
            getString(R.string.university_detail4),
            getString(R.string.university_detail5),
            getString(R.string.university_detail6),
            getString(R.string.university_detail7),
            getString(R.string.university_detail8),
            getString(R.string.university_detail9),
            getString(R.string.university_detail10),
            getString(R.string.university_detail11)
        )

        //to set hav bhav of inside recycler view horizontal, vertical, scroll, uniform grid
        myRecyclerView.layoutManager = LinearLayoutManager(this)

        //initialized universityList
        universityList = arrayListOf<UniversityInfo>()

        for (startingIndex in universityImgArray.indices){
            val uni = UniversityInfo(universityNameArray[startingIndex],
                universityImgArray[startingIndex],
                universityDetails[startingIndex])
            universityList.add(uni)
        }

        //set adapter
        val myAdapter = MyAdapter(universityList,this)
        myRecyclerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener{
            override fun OnItemClick(position: Int) {
                val intent = Intent(applicationContext,UniversityDetails::class.java)
                intent.putExtra("universityName",universityList[position].universityName)
                intent.putExtra("universityImage",universityList[position].universityImage)
                intent.putExtra("universityDetails",universityList[position].UniversityDetails)
                startActivity(intent)
            }

        })

    }
}

