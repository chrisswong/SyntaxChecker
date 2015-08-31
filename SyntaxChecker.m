BOOL validateSyntax(NSString * syntax) {
    
    if ( syntax.length == 0) {
        return false;
    }
    
    NSLog(@"checking %@ " , syntax);
    
    NSDictionary *openersAndCloserMapping = @{ @"(" : @")" ,
                                               @"{" : @"}" ,
                                               @"[" : @"]" };
    
    NSArray *openers = [openersAndCloserMapping allKeys];
    NSArray *closers = [openersAndCloserMapping allValues];
    
    NSMutableArray *stack = [NSMutableArray arrayWithCapacity:syntax.length];
    
    for (NSInteger i = 0; i < syntax.length; i++) {
        NSString *character = [syntax substringWithRange:NSMakeRange(i, 1)];
        
        if ([openers indexOfObject:character] != NSNotFound) {
            [stack addObject:character];
        } else if ([closers indexOfObject:character] != NSNotFound) {
            //if this closing character is matching last opening character
            NSString *lastOpener = [stack lastObject];
            if (![[openersAndCloserMapping objectForKey:lastOpener] isEqualToString:character]  ) {
                return false;
            } else {
                [stack removeObject:lastOpener];
            }
        }
        printList(stack);
    }

    return ([stack count] == 0);
}
