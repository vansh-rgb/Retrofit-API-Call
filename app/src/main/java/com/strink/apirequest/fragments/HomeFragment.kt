package com.strink.apirequest.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.strink.apirequest.adapter.MovieAdapter
import com.strink.apirequest.api.MovieRequest
import com.strink.apirequest.api.RetrofitInstance
import com.strink.apirequest.data.TheMovieDB
import com.strink.apirequest.databinding.FragmentHomeBinding
import retrofit2.*

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val binding
        get() = _binding
    private lateinit var adapter: MovieAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val service = RetrofitInstance.retrofitInstance?.create(MovieRequest::class.java)
        val call = service?.getMovies()
        call?.enqueue(object : Callback<TheMovieDB> {
            override fun onResponse(call: Call<TheMovieDB>, response: Response<TheMovieDB>) {
                if (response.isSuccessful) {
                    binding.recyclerView.layoutManager = LinearLayoutManager(activity as Context)
                    adapter = MovieAdapter(response.body()!!.results, activity as Context)
                    binding.recyclerView.adapter = adapter
                    binding.recyclerView.setHasFixedSize(true)
                }
            }
            override fun onFailure(call: Call<TheMovieDB>, t: Throwable) {
                Log.d("Response", t.message.toString())
            }
        })
    }

}