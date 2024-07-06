import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class TimerWidget extends StatefulWidget {
  @override
  _TimerWidgetState createState() => _TimerWidgetState();
}

class _TimerWidgetState extends State<TimerWidget> {
  static const maxSeconds = 1500; // 25 minutes
  int seconds = maxSeconds;
  bool isRunning = false;
  late Timer timer;

  void startTimer() {
    if (isRunning) return;
    timer = Timer.periodic(Duration(seconds: 1), (timer) {
      setState(() {
        if (seconds > 0) {
          seconds--;
        } else {
          timer.cancel();
        }
      });
    });
    setState(() {
      isRunning = true;
    });
  }

  void stopTimer() {
    if (!isRunning) return;
    timer.cancel();
    setState(() {
      isRunning = false;
    });
  }

  void resetTimer() {
    stopTimer();
    setState(() {
      seconds = maxSeconds;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          '${(seconds ~/ 60).toString().padLeft(2, '0')}:${(seconds % 60).toString().padLeft(2, '0')}',
          style: TextStyle(fontSize: 48),
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: startTimer,
              child: Text(AppLocalizations.of(context)!.start),
            ),
            SizedBox(width: 10),
            ElevatedButton(
              onPressed: stopTimer,
              child: Text(AppLocalizations.of(context)!.stop),
            ),
            SizedBox(width: 10),
            ElevatedButton(
              onPressed: resetTimer,
              child: Text(AppLocalizations.of(context)!.reset),
            ),
          ],
        ),
      ],
    );
  }
}