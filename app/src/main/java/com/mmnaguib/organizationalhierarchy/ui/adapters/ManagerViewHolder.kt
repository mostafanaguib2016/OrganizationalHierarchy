package com.mmnaguib.organizationalhierarchy.ui.adapters

import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.mmnaguib.organizationalhierarchy.R
import com.mmnaguib.organizationalhierarchy.databinding.ItemEmployeeBinding
import com.mmnaguib.organizationalhierarchy.databinding.ItemManagerBinding
import com.mmnaguib.organizationalhierarchy.model.Data
import com.mmnaguib.organizationalhierarchy.model.Manager
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class ManagerViewHolder(val binding: ItemManagerBinding): GroupViewHolder(binding.root)
{

    fun bind(item: Manager){

        binding.empNameTv.text = item.manager.Name
        binding.empPositionTv.text = item.manager.JobTitle

    }

    override fun expand() {
        animateExpand()
    }

    override fun collapse() {
        animateCollapse()
    }

    private fun animateExpand() {
        val rotate = RotateAnimation(360F, 180F, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 300
        rotate.fillAfter = true
        binding.ivBack.setImageDrawable(binding.root.context.getDrawable(R.drawable.ic_arrow_down))
    }

    private fun animateCollapse() {
        val rotate = RotateAnimation(180F, 360F, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 300
        rotate.fillAfter = true
        binding.ivBack.setImageDrawable(binding.root.context.getDrawable(R.drawable.ic_arrow))
    }

}