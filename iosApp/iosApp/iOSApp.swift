import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    init() {
        KoinInitializerKt.initialiseKoin()
        }
    
    var body: some Scene {
        WindowGroup {
            UserListView()
        }
    }
}
