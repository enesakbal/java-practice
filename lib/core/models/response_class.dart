// To parse this JSON data, do
//
//     final responseClass = responseClassFromJson(jsonString);

import 'dart:convert';

List<ResponseClass> responseClassFromJson(String str) => List<ResponseClass>.from(json.decode(str).map((x) => ResponseClass.fromJson(x)));

String responseClassToJson(List<ResponseClass> data) => json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class ResponseClass {
    ResponseClass({
        this.url,
        this.description,
    });

    String? url;
    String? description;

    factory ResponseClass.fromJson(Map<String, dynamic> json) => ResponseClass(
        url: json['url'],
        description: json['description'],
    );

    Map<String, dynamic> toJson() => {
        'url': url,
        'description': description,
    };
}
