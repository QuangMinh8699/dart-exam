import 'dart:convert';
import 'package:http/http.dart' as http;

void main() async {
  final apiUrl = 'http://localhost:8080/get-list-customers';

  final customers = await fetchCustomers(apiUrl);
  print('All customers:');
  print(customers);

  final newCustomer = {
    'fullname': 'Alan',
    'birthday': 4172,
    'address': 'new york',
  };

  final createdCustomer = await createCustomer(apiUrl, newCustomer);
  print('Created Customer:');
  print(createdCustomer);
}

Future<List<Map<String, dynamic>>> fetchCustomers(String apiUrl) async {
  final response = await http.get(Uri.parse(apiUrl));
  if (response.statusCode == 200) {
    final List<dynamic> data = json.decode(response.body);
    return List<Map<String, dynamic>>.from(data);
  } else {
    throw Exception('Failed to fetch');
  }
}

Future<Map<String, dynamic>> createCustomer(
    String apiUrl, Map<String, dynamic> customer) async {
  final response = await http.post(
    Uri.parse(apiUrl),
    headers: {'Content-Type': 'application/json'},
    body: json.encode(customer),
  );

  if (response.statusCode == 200) {
    return json.decode(response.body);
  } else {
    throw Exception('Failed to create');
  }
}
