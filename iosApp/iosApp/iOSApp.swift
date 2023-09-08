import SwiftUI
import shared
@main
struct iOSApp: App {
    let sdk = NasaSdk()
    var body: some Scene {
        WindowGroup {
            ContentView(viewModel: .init(sdk: sdk))
        }
    }
}
