import SwiftUI
import shared

@main
struct iOSApp: App {
	var body: some Scene {
        let sdk = NasaSdk()
		WindowGroup {
            ContentView(viewModel: .init(sdk: sdk))
		}
	}
}
