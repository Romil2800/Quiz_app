package romilp.quizapp.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import romilp.quizapp.R
import romilp.quizapp.activities.QuestionActivity
import romilp.quizapp.models.Questions
import romilp.quizapp.models.Quiz
import romilp.quizapp.utils.ColorPicker
import romilp.quizapp.utils.IconPicker

class QuizAdapter(val context: Context, private val quizzes: List<Quiz>) :
    RecyclerView.Adapter<QuizViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.quiz_item, parent, false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.quizTitle.text = quizzes[position].title
        holder.cardContainer.setBackgroundColor(Color.parseColor(ColorPicker.getColor()))
        holder.quizIcon.setImageResource(IconPicker.getIcon())

        holder.itemView.setOnClickListener{
            val intent= Intent(context,QuestionActivity::class.java)
            intent.putExtra("DATE",quizzes[position].title)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return quizzes.size
    }

}