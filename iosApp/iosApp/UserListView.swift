//
//  UserListView.swift
//  iosApp
//
//  Created by Arun Kumar on 24/01/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct UserListView: View {
    @StateObject private var viewModel = UserViewModel()

//    var body: some View {
//        List(viewModel.users, id: \.self) { user in
//            Text("Name: "+user.name)
//            Text("Email: "+user.email)
//            Text("Role: "+user.role)
//        }
//        .onAppear {
//            viewModel.fetchUsers()
//        }
//    }
    
    var body: some View {
           VStack {
               List(viewModel.users, id: \.self) { user in
                   UserListItemView(user: user) {
                       // Handle item click here
                   }
               }
               .onAppear {
                   viewModel.fetchUsers()
               }
           }
       }
    
}

struct UserListItemView: View {
    let user: UserItem
    let onClick: () -> Void

    var body: some View {
        Button(action: {
            onClick()
        }) {
            HStack(alignment: .center, spacing: 8) {

                VStack(alignment: .leading, spacing: 4) {
                    Text("Name: \(user.name)")
                        .font(.headline)
                    Text("Email: \(user.email)")
                        .font(.subheadline)
                        .lineLimit(2)
                    Text("Role: \(user.role)")
                        .font(.footnote)
                        .foregroundColor(.secondary)
                }
                Spacer()
            }
            .padding()
            .background(
                RoundedRectangle(cornerRadius: 8)
                    .fill(Color.white)
                    .shadow(color: Color.gray.opacity(0.4), radius: 4, x: 0, y: 2)
            )
        }
        .buttonStyle(PlainButtonStyle())
        .padding(.horizontal, 8)
    }
}
