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
        switch viewModel.mars {
        case .loading:
            AnyView(Text("Loading...").multilineTextAlignment(.center))
            
        case .result(let mars):
            AnyView(
            ScrollView {
                LazyVStack(spacing: 10) {
                    ForEach(mars.photos.indices, id:\.self) { index in
                        HStack(spacing: 5){
                            AsyncImage(url: URL(string: mars.photos[index].img_src)) { image in
                                                   VStack {
                                                       image.image?
                                                           .resizable()
                                                           .aspectRatio(contentMode: .fit)
                                                           .frame(maxWidth: 200, maxHeight: 200)
                                                       
                                                   }
                            }
                            VStack(spacing: 5){
                                Text("Camera : \(mars.photos[index].camera.name)").multilineTextAlignment(.leading).foregroundStyle(.white)
                                Text("Name : \(mars.photos[index].rover.name)").multilineTextAlignment(.leading).foregroundStyle(.white)
                                Text("Sol : \(mars.photos[index].sol)").multilineTextAlignment(.leading).foregroundStyle(.white)
                                Text("Status : \(mars.photos[index].rover.status)").multilineTextAlignment(.leading).foregroundStyle(.white)
                                Text("Total Images : \(mars.photos[index].rover.total_photos)").multilineTextAlignment(.leading).foregroundStyle(.white)
                            }
                        }.background(.gray).cornerRadius(10)
                        
                    }
                }.frame(maxWidth: .infinity)
            })
        case .error:
            AnyView(Text("Something went wrong!").multilineTextAlignment(.center))
        }
    
    }
}



extension ContentView {
    
    enum MarsResponse {
           case loading
           case result(MarsEntity)
           case error(String)
       }

    
    @MainActor
    class ViewModel: ObservableObject {
        let sdk: NasaSdk
         @Published var mars = MarsResponse.loading
        
        init(sdk: NasaSdk) {
            self.sdk = sdk
            getMarsData()
            
        }
        
        func getMarsData() {
            Task {
                do {
                    self.mars = MarsResponse.loading
                    let marsResponse = try await sdk.getNasaMarsImages()
                    self.mars = .result(marsResponse)
                    print("success")
                } catch {
                    self.mars = MarsResponse.error(error.localizedDescription)
                    print("error")
                }
            }
        }
    }
 
}

extension MarsEntity: Identifiable { }


