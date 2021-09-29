package com.example.recycleviewmultipleviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.recycleviewmultipleviews.ItemClass.LayoutOne;
import static com.example.recycleviewmultipleviews.ItemClass.LayoutTwo;
import static com.example.recycleviewmultipleviews.ItemClass.LayoutThree;

public class AdapterClass extends RecyclerView.Adapter {

    public List<ItemClass> itemClassList;

    // public constructor for this class
    public AdapterClass(List<ItemClass> itemClassList)
    {
        this.itemClassList = itemClassList;
    }

    // Override the getItemViewType method.
    // This method uses a switch statement
    // to assign the layout to each item
    // depending on the viewType passed

    @Override
    public int getItemViewType(int position)
    {
        switch (itemClassList.get(position).getViewType()) {
            case 0:
                return LayoutOne;
            case 1:
                return LayoutTwo;
            case 2:
                return LayoutThree;
            default:
                return -1;
        }
    }

    // Create classes for each layout ViewHolder.

    class LayoutOneViewHolder
            extends RecyclerView.ViewHolder {

        private TextView textview;
        private ImageView delete;
        private ConstraintLayout constraintLayout;

        public LayoutOneViewHolder(@NonNull View itemView)
        {
            super(itemView);

            // Find the Views
            textview = itemView.findViewById(R.id.text);
            delete = itemView.findViewById(R.id.delete);
            constraintLayout
                    = itemView.findViewById(R.id.constraintlayout1);
        }

        // method to set the views that will
        // be used further in onBindViewHolder method.
        private void setView(String text,int image1)
        {
            delete.setImageResource(image1);
            textview.setText(text);
        }
    }

    // similarly a class for the second layout is also
    // created.

    class LayoutTwoViewHolder
            extends RecyclerView.ViewHolder {

        private ImageView icon;
        private TextView text_one, text_two;
        private ImageView delete;
        private ConstraintLayout constraintLayout;

        public LayoutTwoViewHolder(@NonNull View itemView)
        {
            super(itemView);
            icon = itemView.findViewById(R.id.media_image);
            delete = itemView.findViewById(R.id.delete);
            text_one = itemView.findViewById(R.id.textView);
            text_two = itemView.findViewById(R.id.descView);

            constraintLayout
                    = itemView.findViewById(R.id.constraintlayout2);
        }

        private void setViews(int image,int image1, String textOne,
                              String textTwo)
        {
            icon.setImageResource(image);
            delete.setImageResource(image1);
            text_one.setText(textOne);
            text_two.setText(textTwo);
        }
    }

    class LayoutThreeViewHolder
            extends RecyclerView.ViewHolder {

        private TextView textview;

        private LinearLayout linearlayout;

        public LayoutThreeViewHolder(@NonNull View itemView)
        {
            super(itemView);

            // Find the Views
            textview = itemView.findViewById(R.id.text);

            linearlayout
                    = itemView.findViewById(R.id.linearlayout1);
        }

        // method to set the views that will
        // be used further in onBindViewHolder method.
        private void setViews(String text)
        {

            textview.setText(text);
        }
    }

    // In the onCreateViewHolder, inflate the
    // xml layout as per the viewType.
    // This method returns either of the
    // ViewHolder classes defined above,
    // depending upon the layout passed as a parameter.

    @NonNull
    @Override
    public RecyclerView.ViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        switch (viewType) {
            case LayoutOne:
                View layoutOne
                        = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_one, parent,
                                false);
                return new LayoutOneViewHolder(layoutOne);
            case LayoutTwo:
                View layoutTwo
                        = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.album_card_view1, parent,
                                false);
                return new LayoutTwoViewHolder(layoutTwo);

            case LayoutThree:
                View layoutThree
                        = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_three, parent,
                                false);
                return new LayoutThreeViewHolder(layoutThree);
            default:
                return null;
        }
    }

    // In onBindViewHolder, set the Views for each element
    // of the layout using the methods defined in the
    // respective ViewHolder classes.

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (itemClassList.get(position).getViewType()) {
            case LayoutOne:

                String text
                        = itemClassList.get(position).getText();
                int image1
                        = itemClassList.get(position).getdelete();

                ((LayoutOneViewHolder)holder).setView(text, image1);

                ((LayoutOneViewHolder)holder)
                        .delete.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {
                                removeItem(position);
                                Toast
                                        .makeText(
                                                view.getContext(),
                                                "Remove Layout One!",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                // The following code pops a toast message
                // when the item layout is clicked.
                // This message indicates the corresponding
                // layout.
                ((LayoutOneViewHolder)holder)
                        .constraintLayout.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {

                                Toast
                                        .makeText(
                                                view.getContext(),
                                                "Hello from Layout One!",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });

                break;

            case LayoutTwo:
                int image
                        = itemClassList.get(position).geticon();
                int image2
                        = itemClassList.get(position).getdelete();
                String text_one
                        = itemClassList.get(position).getText_one();
                String text_two
                        = itemClassList.get(position).getText_two();
                ((LayoutTwoViewHolder)holder)
                        .setViews(image,image2, text_one, text_two);

                ((LayoutTwoViewHolder)holder)
                        .delete.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {
                                removeItem(position);
                                Toast
                                        .makeText(
                                                view.getContext(),
                                                "Remove Layout Two!",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });

                ((LayoutTwoViewHolder)holder)
                        .constraintLayout.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {

                                Toast
                                        .makeText(
                                                view.getContext(),
                                                "Hello from Layout Two!",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                break;

            case LayoutThree:

                String text1
                        = itemClassList.get(position).getText();

                ((LayoutThreeViewHolder)holder).setViews(text1);


                // The following code pops a toast message
                // when the item layout is clicked.
                // This message indicates the corresponding
                // layout.
                ((LayoutThreeViewHolder)holder)
                        .linearlayout.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {

                                Toast
                                        .makeText(
                                                view.getContext(),
                                                position+ " Hello from Layout Three!",
                                                Toast.LENGTH_SHORT)
                                        .show();


                            }
                        });

                break;
            default:
                return;
        }
    }

    public void removeItem(int position) {
        // Get the clicked item label
        ItemClass itemLabel = itemClassList.get(position);
        // Remove the item on remove/button click
        itemClassList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,itemClassList.size());
        // Show the removed item label
        //Toast.makeText(this.getContext(),"Removed : " + itemLabel,Toast.LENGTH_SHORT).show();

    }

    public void restoreItem(ItemClass item, int position) {
        // Get the clicked item label
        //ItemClass itemLabel = itemClassList.get(position);
        // Remove the item on remove/button click
        itemClassList.add(position, item);
        notifyItemInserted(position);
        //notifyItemRangeChanged(position,itemClassList.size());
        // Show the removed item label
        //Toast.makeText(this.getContext(),"Removed : " + itemLabel,Toast.LENGTH_SHORT).show();

    }

    // This method returns the count of items present in the
    // RecyclerView at any given time.

    @Override
    public int getItemCount()
    {
        return itemClassList.size();
    }
}
