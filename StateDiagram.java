private enum StateType : int
 {
         ProcessOrder_Delivered,
         ProcessOrder_Packed,
         ProcessOrder_Closed,
         ProcessOrder_Dispatched,
         ProcessOrder_New,
         ST_NOSTATE
 }
 private enum TransitionType : int
 {
         ProcessOrder_Delivered_to_ProcessOrder_Closed,
         TT_NOTRANSITION
 }
 private enum CommandType
 {
         Do,
         Entry,
         Exit
 }
 private StateType currState;
 private StateType nextState;
 private TransitionType currTransition;
 private boolean transcend;
 private StateType ProcessOrder_history;        
 private void processOrder_Delivered(CommandType command)
 {
         switch(command)
         {
                 case Do:
                 {
                         // Do Behaviors..
                         setStatus(Delivered);
                         // State's Transitions
                         if((status==Delivered))
                         {
                                 nextState = StateType.ProcessOrder_Closed;
                                 currTransition = TransitionType.ProcessOrder_Delivered_to_ProcessOrder_Closed;
                         }
                         break;
                 }
                 default:
                 {
                         break;
                 }
         }
 }
 
 private void processOrder_Packed(CommandType command)
 {
         switch(command)
         {
                 case Do:
                 {
                         // Do Behaviors..
                         setStatus(Packed);
                         // State's Transitions
                         nextState = StateType.ProcessOrder_Dispatched;
                         break;
                 }
                 default:
                 {
                         break;
                 }
         }
 }
 
 private void processOrder_Closed(CommandType command)
 {
         switch(command)
         {
                 case Do:
                 {
                         // Do Behaviors..
                         // State's Transitions
                         break;
                 }
                 default:
                 {
                         break;
                 }
         }
 }
 
 private void processOrder_Dispatched(CommandType command)
 {
         switch(command)
         {
                 case Do:
                 {
                         // Do Behaviors..
                         setStatus(Dispatched);
                         // State's Transitions
                         nextState = StateType.ProcessOrder_Delivered;
                         break;
                 }
                 default:
                 {
                         break;
                 }
         }
 }
 
 private void processOrder_New(CommandType command)
 {
         switch(command)
         {
                 case Do:
                 {
                         // Do Behaviors..
                         setStatus(new);
                         // State's Transitions
                         nextState = StateType.ProcessOrder_Packed;
                         break;
                 }
                 default:
                 {
                         break;
                 }
         }
 }
 private void StatesProc(StateType currState, CommandType command)
 {
         switch(currState)
         {
                 case ProcessOrder_Delivered:
         {
                 processOrder_Delivered(command);
                 break;
         }
 
         case ProcessOrder_Packed:
         {
                 processOrder_Packed(command);
                 break;
         }
 
         case ProcessOrder_Closed:
         {
                 processOrder_Closed(command);
                 break;
         }
 
         case ProcessOrder_Dispatched:
         {
                 processOrder_Dispatched(command);
                 break;
         }
 
         case ProcessOrder_New:
         {
                 processOrder_New(command);
                 break;
         }
                 default:
                         break;
         }
 }
 private void TransitionsProc(TransitionType transition)
 {
         switch(transition)
         {
                 case ProcessOrder_Delivered_to_ProcessOrder_Closed:
                 {
                         setStatus(closed);
                         break;
                 }
                 default:
                         break;
         }
 }
 private void initalizeStateMachine()
 {
         currState = StateType.ProcessOrder_New;
         nextState = StateType.ST_NOSTATE;
         currTransition = TransitionType.TT_NOTRANSITION;
 }
 
 
 private void runStateMachine()
 {
         while(true)
         {
                 if ( currState == StateType.ST_NOSTATE )
                 {
                         break ;
                 }
                 
                 currTransition = TransitionType.TT_NOTRANSITION;
                 StatesProc(currState, CommandType.Do);
 // then check if there is any valid transition assigned after the do behavior
                 if ( nextState == StateType.ST_NOSTATE)
                 {
                         break;
                 }
                 
                 if ( currTransition != TransitionType.TT_NOTRANSITION )
                 {
                         TransitionsProc( currTransition );
                 }
                 if ( currState != nextState)
                 {
                         StatesProc(currState, CommandType.Exit);
                         StatesProc(nextState, CommandType.Entry);
                         currState = nextState ;
                 }
         }
