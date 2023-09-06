//
//  RocketLaunchRow.swift
//  iosApp
//
//  Created by Ashutosh Wahane on 06/09/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketLaunchRow: View {
    var mars: MarsEntity

    var body: some View {
        HStack() {
            VStack(alignment: .leading, spacing: 10.0) {
                Text("Launch name: \(mars)")
                Text(launchText).foregroundColor(launchColor)
//                Text("Launch year: \(String(rocketLaunch.launchYear))")
//                Text("Launch details: \(rocketLaunch.details ?? "")")
            }
            Spacer()
        }
    }
}

extension RocketLaunchRow {
    private var launchText: String {
        "test"
//        if let isSuccess = mars.launchSuccess {
//            return isSuccess.boolValue ? "Successful" : "Unsuccessful"
//        } else {
//            return "No data"
//        }
    }

    private var launchColor: Color {
        Color.gray
//        if let isSuccess = rocketLaunch.launchSuccess {
//            return isSuccess.boolValue ? Color.green : Color.red
//        } else {
//            return Color.gray
//        }
    }
}
