//
//  UserViewModel.swift
//  iosApp
//
//  Created by Arun Kumar on 24/01/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Shared

class UserViewModel: ObservableObject {
    @Published var users: [UserItem] = []

    private let sharedLogic = SharedLogic()

    func fetchUsers() {
        sharedLogic.fetchUsers { [weak self] userList in
            print("User List: \(userList)")
            DispatchQueue.main.async {
                self?.users = userList
            }
        }
    }
}
