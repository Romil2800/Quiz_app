package romilp.quizapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import romilp.quizapp.R
import romilp.quizapp.models.Questions

class OptionAdapter(val context: Context, val questions: Questions) :
    RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {

    private var options: List<String> =
        listOf(questions.option1, questions.option2, questions.option3, questions.option4)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.option_item, parent, false)
        return OptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.optionView.text = options[position]
        holder.itemView.setOnClickListener{
            //Toast.makeText(context,options[position],Toast.LENGTH_SHORT).show()
            questions.userAnswer=options[position]
            notifyDataSetChanged()
        }

        if(questions.userAnswer==options[position]){
           holder.itemView.setBackgroundResource(R.drawable.option_item_selected_bg)
        }

       else{
            holder.itemView.setBackgroundResource(R.drawable.option_item_bg)
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }

    inner class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var optionView = itemView.findViewById<TextView>(R.id.quiz_option)
    }


}

