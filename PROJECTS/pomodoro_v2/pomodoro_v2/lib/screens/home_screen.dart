import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../../services/localization_service.dart';
import '../../widgets/timer_widget.dart';
import '../../widgets/language_switcher.dart';

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final localizationService = Provider.of<LocalizationService>(context);
    return Scaffold(
      appBar: AppBar(
        title: Text(AppLocalizations.of(context)!.appTitle),
        actions: [
          LanguageSwitcher(),
        ],
      ),
      body: Center(
        child: TimerWidget(),
      ),
    );
  }
}