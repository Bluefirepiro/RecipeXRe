package com.example.recipexx

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShareWithFamilyAdapter(private val context: Context, private val familyMembers: List<FamilyMember>) :
    RecyclerView.Adapter<ShareWithFamilyAdapter.FamilyMemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyMemberViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.family_member_item_layout, parent, false)
        return FamilyMemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: FamilyMemberViewHolder, position: Int) {
        val member = familyMembers[position]
        holder.bind(member)
    }

    override fun getItemCount(): Int {
        return familyMembers.size
    }

    inner class FamilyMemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val memberNameTextView: TextView = itemView.findViewById(R.id.textViewMemberName)
        private val memberAgeTextView: TextView = itemView.findViewById(R.id.textViewMemberAge)
        private val memberRelationshipTextView: TextView = itemView.findViewById(R.id.textViewMemberRelationship)
        private val memberEmailTextView: TextView = itemView.findViewById(R.id.textViewMemberEmail)
        private val memberPhoneTextView: TextView = itemView.findViewById(R.id.textViewMemberPhone)

        fun bind(member: FamilyMember) {
            memberNameTextView.text = member.name
            memberAgeTextView.text = "Age: ${member.age}"
            memberRelationshipTextView.text = "Relationship: ${member.relationship}"
            memberEmailTextView.text = "Email: ${member.email}"
            memberPhoneTextView.text = "Phone: ${member.phoneNumber}"
        }
    }
}
