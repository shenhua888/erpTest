Local $flag
For $i = 5 To 1 Step -1
   WinActivate ( "打开" )
   $flag = WinActive ( "打开" )
   If $flag <> 0 Then ExitLoop
   Sleep(2000)
Next
If $flag == 0 Then
   ConsoleWrite ( "fail" )
Else
   Sleep(2000)
   ControlSend("打开", "", "Edit1", $CmdLine[1])
   ;ControlSend("打开", "", "Edit1", "F;\picture\dd5.png")
   Local $value =  ControlGetText("打开", "", "Edit1")
   ;ConsoleWrite ( $value )
   For $j = 5 To 1 Step -1
	  If $value == $CmdLine[1] Then ExitLoop
	  ;If $value == "F:\picture\dd5.png" Then ExitLoop
	  ControlClick("打开", "", "Edit1")
	  Send("{CTRLDOWN}")
	  Sleep(1000)
	  Send("a")
	  Sleep(1000)
	  Send("{CTRLUP}")
	  Sleep(1000)
	  ControlSend("打开", "", "Edit1", $CmdLine[1])
	  ;ControlSend("打开", "", "Edit1", "F:\picture\dd5.png")
	  Sleep(1000)
	  $value =  ControlGetText("打开", "", "Edit1")
   Next
   Sleep(1000)
   ControlClick("打开", "", "Button1")
   ConsoleWrite ( "success" )
EndIf



