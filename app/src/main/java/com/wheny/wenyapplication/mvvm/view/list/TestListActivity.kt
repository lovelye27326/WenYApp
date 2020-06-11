package com.wheny.wenyapplication.mvvm.view.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wheny.wenyapplication.R
import com.wheny.wenyapplication.adapter.test_adapter.TestListAdapter
import com.wheny.wenyapplication.adapter.test_adapter.TestListVm
import com.wheny.wenyapplication.data.TestListBean
import com.wheny.wenyapplication.databinding.TestListItemLayoutBinding
import com.wheny.whenylibrary.adapter.MultiTypeItemAdapter
import com.wheny.whenylibrary.adapter.SafeLinearLayoutManager
import com.wheny.whenylibrary.adapter.SimpleItemViewDelegate
import com.wheny.whenylibrary.adapter.ViewHolder
import kotlinx.android.synthetic.main.activity_test_list.*

class TestListActivity : AppCompatActivity() {

    lateinit var testListAdapter:TestListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_test_list)

        var list = arrayListOf(TestListBean("2"),TestListBean("1"),TestListBean("1"),
                TestListBean("1"),TestListBean("1"),TestListBean("2"),TestListBean("1"),TestListBean("1"),
                TestListBean("1"),TestListBean("1"),TestListBean("4"),TestListBean("1"),TestListBean("1"),
                TestListBean("1"),TestListBean("3"),TestListBean("3"),TestListBean("1"),TestListBean("1"),
                TestListBean("1"),TestListBean("1"),TestListBean("1"),TestListBean("1"),TestListBean("1"),
                TestListBean("1"),TestListBean("1"),TestListBean("1"),TestListBean("1"),TestListBean("1"))

        val addItemViewDelegate = MultiTypeItemAdapter(list)
                .addItemViewDelegate(object : SimpleItemViewDelegate<TestListBean, TestListItemLayoutBinding>() {

                    override fun getItemViewLayoutId(): Int {
                        return R.layout.test_list_item_layout
                    }

                    override fun injectViewModel(viewDataBinding: TestListItemLayoutBinding?) {
                        viewDataBinding?.testListVm = TestListVm()
                    }

                    override fun isForViewType(item: TestListBean?, position: Int): Boolean {
                        return item is TestListBean
                    }

                    override fun convert(holder: ViewHolder<TestListItemLayoutBinding>?, t: TestListBean?, position: Int) {
                        holder?.viewDataBinding?.testListVm?.txt2 = t?.txt.toString()



                    }

                })
        rv.layoutManager = SafeLinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv.adapter = addItemViewDelegate

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

}
