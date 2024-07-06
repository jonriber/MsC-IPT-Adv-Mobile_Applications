import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../services/localization_service.dart';

class LanguageSwitcher extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final localizationService = Provider.of<LocalizationService>(context);
    return DropdownButton<Locale>(
      value: localizationService.locale,
      icon: Icon(Icons.language),
      onChanged: (Locale? locale) {
        if (locale != null) {
          localizationService.setLocale(locale);
        }
      },
      items: L10n.all.map((locale) {
        final flag = L10n.getFlag(locale.languageCode);
        return DropdownMenuItem(
          value: locale,
          child: Center(
            child: Text(
              flag,
              style: TextStyle(fontSize: 24),
            ),
          ),
        );
      }).toList(),
    );
  }
}