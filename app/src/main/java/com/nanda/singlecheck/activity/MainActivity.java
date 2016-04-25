/***
 * Copyright (c) 2008-2015 CommonsWare, LLC
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain	a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 * by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS,	WITHOUT	WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * <p/>
 * From _The Busy Coder's Guide to Android Development_
 * https://commonsware.com/Android
 */

package com.nanda.singlecheck.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.nanda.singlecheck.R;
import com.nanda.singlecheck.adapter.SingleCheckAdapter;
import com.nanda.singlecheck.entity.PersonItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Bind(R.id.recylcerview)
    RecyclerView mRecyclerView;

    private List<PersonItem> mSingleCheckList = new ArrayList<>();
    private SingleCheckAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mSingleCheckList.clear();
        for (int i = 0; i < 20; i++) {
            mSingleCheckList.add(new PersonItem("This is a sample for single check Recycelrview"));
        }

        mAdapter = new SingleCheckAdapter(this, mSingleCheckList);
        mRecyclerView = (RecyclerView) findViewById(R.id.recylcerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, position + " - " + mSingleCheckList.get(position).getPersonName(), Toast.LENGTH_SHORT).show();
    }
}
