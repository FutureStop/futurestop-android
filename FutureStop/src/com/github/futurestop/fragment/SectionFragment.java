/**
 * 
 */
package com.github.futurestop.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.futurestop.R;
import com.github.futurestop.loader.SampleLoader;
import com.github.futurestop.model.FSModel;

/**
 * @author Chung-Yi Cho
 *
 */
public class SectionFragment extends Fragment 
    implements LoaderManager.LoaderCallbacks<FSModel> {
    public static final String ARG_SECTION_NUMBER = "section_number";
    private TextView mTextView;
    
    public SectionFragment() {
        
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_dummy, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.section_label);
        mTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        getLoaderManager().initLoader(0, null, this);
    }

    private void setupUI(FSModel result) {
        mTextView.setText((CharSequence) result.data);
    }

    @Override
    public Loader<FSModel> onCreateLoader(int id, Bundle args) {
        Loader loader = new SampleLoader(getActivity()); 
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<FSModel> loader, FSModel result) {
        setupUI(result);
    }

    @Override
    public void onLoaderReset(Loader<FSModel> loader) {
        
    }
}
