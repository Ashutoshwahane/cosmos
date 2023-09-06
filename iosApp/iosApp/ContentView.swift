import UIKit
import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        Main_iosKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    
    @ObservedObject private(set) var viewModel: ViewModel
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.all, edges: .bottom) // Compose has own keyboard handler
    }
}


extension ContentView {
    
    @MainActor
    class ViewModel: ObservableObject {
        let sdk: NasaSdk
        // @Published var launches = LoadableLaunches.loading
        
        init(sdk: NasaSdk) {
            self.sdk = sdk
            loadLaunches()
            
        }
        
        func loadLaunches() {
            Task {
                do {
                    let marsResponse = try await sdk.getNasaMarsImages()
                    print(marsResponse.photos[0].sol)
                    print("success")
                } catch {
                    print("error")
                }
            }
        }
    }
    
}
