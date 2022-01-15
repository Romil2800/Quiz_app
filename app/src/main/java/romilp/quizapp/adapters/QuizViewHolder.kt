package romilp.quizapp.adapters

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import romilp.quizapp.R

class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    private var binding: QuizItemBinding =
//        DataBindingUtil.setContentView( Quiz,R.layout.quiz_item)

    var quizIcon: ImageView = itemView.findViewById(R.id.quizIcon)
    var quizTitle: TextView =itemView.findViewById(R.id.quizTitle)
    var cardContainer:CardView=itemView.findViewById(R.id.cardContainer)
}