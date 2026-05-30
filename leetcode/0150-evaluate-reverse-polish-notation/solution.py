class Solution:
    def evalRPN(self, tokens: List[str]) -> int:

        s =[]
        
        for token in tokens:    

            if token not in ('+','-','*','/'):

                s.append(token)

            else:

                A = s.pop()
                B = s.pop()
                a = int(A)
                b = int(B)

                if token == '+':

                    t = a + b

                    s.append(t)

                elif token == '-':

                    t = b - a 

                    s.append(t)

                elif token == '/':

                    t = b / a
                    s.append(t)

                elif token == '*':

                    t = a * b
                    s.append(t)

        ans = s.pop()
        return int(ans)

                    


