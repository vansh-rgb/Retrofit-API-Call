package com.strink.apirequest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.strink.apirequest.R
import com.strink.apirequest.data.Result
import org.w3c.dom.Text

class MovieAdapter(private val movies: List<Result>, private val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()  {

    inner class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val movieName: TextView = view.findViewById(R.id.movieNameTV)
        val moviePoster : ImageView = view.findViewById(R.id.moviePosterTV)
        val movieRating: TextView = view.findViewById(R.id.movieRatingTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MovieViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        with(holder) {
            movieName.text = movies[position].title
            movieRating.text = movies[position].vote_average.toString()
        }
        Picasso.get().load("https://image.tmdb.org/t/p/original" + movies[position].poster_path)
            .error(R.drawable.ic_launcher_foreground).into(holder.moviePoster)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}