package com.amukelani.hellogroupassessment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raywenderlich.hellogroupassessment.models.ListItems;
import com.raywenderlich.hellogroupassessment.utils.ListItemsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amukelani on 9/25/16.
 */
public class ListItemsFragment extends Fragment {
  private static final String ARGUMENT_RES_ID = "ResId";
  private List<ListItems> listItemses = new ArrayList<>();
  private RecyclerView recyclerView;
  private ListItemsAdapter mAdapter;
  private EditText etTitle;
  private Button btnAddItem;
  private Button btnResetItem;
  private static String PREFS_NAME = "SharedPreferences";

//  private OnRageComicSelected mListener;

  public static ListItemsFragment newInstance(int resId) {

    final Bundle args = new Bundle();
    args.putInt(ARGUMENT_RES_ID, resId);
    final ListItemsFragment fragment = new ListItemsFragment();
    fragment.setArguments(args);
    return fragment;
  }

  public ListItemsFragment() {
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_rage_comic_list, container, false);

    final Activity activity = getActivity();
    recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

    mAdapter = new ListItemsAdapter(listItemses);

    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(mAdapter);

    etTitle = (EditText) view.findViewById(R.id.etTitle);
    btnAddItem = (Button) view.findViewById(R.id.btnAddItem);

    btnResetItem = (Button) view.findViewById(R.id.btnResetItem);

    btnAddItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String title = etTitle.getText().toString();

        if(title != ""){

          ListItems listItems = new ListItems(title, listItemses.size());
          saveData(listItems);

          listItemses.add(listItems);

          mAdapter.notifyItemInserted(listItemses.size() - 1);
        }
        else {
          Toast.makeText(v.getContext(), "You did not enter a Title", Toast.LENGTH_SHORT).show();
        }
      }
    });


    btnResetItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        listItemses.removeAll(listItemses);

          mAdapter.notifyDataSetChanged();

      }
    });

    prepareListItemsData();
    return view;
  }


  private void prepareListItemsData(){

    ListItems listItems = new ListItems("Movies", 1);
    listItemses.add(listItems);

    listItems = new ListItems("Music", 2);
    listItemses.add(listItems);

    listItems = new ListItems("Documents", 3);
    listItemses.add(listItems);

    listItems = new ListItems("Downloads", 4);
    listItemses.add(listItems);

    listItems = new ListItems("Desktop", 5);
    listItemses.add(listItems);
  }


  private void saveData(ListItems listItems){
    SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

    saveTitle(settings, listItems.getTitle());
    saveNum(settings, listItems.getNum());


  }

  private void saveTitle(SharedPreferences settings, String title) {
    SharedPreferences.Editor editor = settings.edit();
    editor.putString("title", title);
    editor.apply();
  }

  private void saveNum(SharedPreferences settings, int num) {
    SharedPreferences.Editor editor = settings.edit();
    editor.putInt("num", num);
    editor.apply();
  }

}
