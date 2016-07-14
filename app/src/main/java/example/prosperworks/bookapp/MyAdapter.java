package example.prosperworks.bookapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by markevans on 7/13/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Book> mDataset;
    private static OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(Object object, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        public Object mObject;
        public TextView titleTV;
        public TextView fNameTV;
        public TextView lNameTV;
        public TextView ageTV;
        public int position;

        public ViewHolder(View v) {
            super(v);
            titleTV = (TextView) v.findViewById(R.id.title);
            fNameTV = (TextView) v.findViewById(R.id.first_name);
            lNameTV = (TextView) v.findViewById(R.id.last_name);
            ageTV = (TextView) v.findViewById(R.id.age);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mOnItemClickListener != null && mObject != null){
                mOnItemClickListener.onItemClick(mObject, position);
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    public void add(int position, Book item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(Book item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(int position) {
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Book> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position) {
        Book b = mDataset.get(position);
        holder.titleTV.setText(b.getTitle());
        holder.fNameTV.setText(b.getFname());
        holder.lNameTV.setText(b.getLname());
        holder.ageTV.setText(b.getAge());
        holder.mObject = b;
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
