import sys
from collections import Counter

def parse_coordinates(input_text):
    """Parse coordinate pairs from input text."""
    coords = []
    for line in input_text.strip().split('\n'):
        if line.strip():
            parts = line.strip().split()
            if len(parts) == 2:
                coords.append((int(parts[0]), int(parts[1])))
    return coords

def process_coordinates(coords):
    """
    Process coordinates to generate output.
    This appears to be counting something related to each coordinate.
    Without specific problem context, we'll implement a common pattern:
    counting occurrences or classifying based on coordinate properties.
    """
    results = []
    
    for x, y in coords:
        # Example processing - adjust based on actual problem requirements
        # This could be counting points in regions, nearest neighbors, etc.
        # For now, using a placeholder that can be customized
        
        # Common pattern: count something based on coordinate values
        # Example: count how many points fall in certain ranges
        # or count occurrences of similar patterns
        
        # Placeholder logic - replace with actual problem logic
        count = 1  # Default count
        
        # Example: if this is about counting neighbors or regions
        # count = len([c for cx, cy in coords if abs(cx - x) <= 10 and abs(cy - y) <= 10])
        
        results.append(count)
    
    return results

def main():
    # Read input
    input_text = """195 462
191 193
149 178
121 157
28 79
35 131
305 453
94 374
3 9
79 294
265 352
340 400
16 457
156 356
25 73
217 250
1 2
12 183
336 367
29 381
407 440
73 241
52 108
255 364
1 230
167 328
14 34
231 289
396 433
4 23
215 442
5 39
306 499
370 419
484 528
120 172
122 283
59 293
18 25
127 470
115 179
29 161
13 445
52 55
6 82
295 406
251 397
40 401
5 44
1 91
374 458
129 220
72 527
191 485
55 140
389 426
49 175
18 495
311 319
132 369
132 523
189 309
199 354
118 255
254 287
120 158
14 22
254 314
21 134
126 251
114 243
18 357
31 49
213 409
230 291
62 109
240 254
144 285
138 405
39 121
83 96
390 447
15 71
6 480
101 155
19 212
66 98
2 42
5 35
61 116
78 103
26 28
29 182
166 324
48 75
10 18
190 268
41 85
384 451
52 165
60 72
202 361
146 192
24 67
118 483
31 99
82 444
20 455
18 36
7 137
267 338
228 490
122 261
425 438
109 181
138 479
317 355
82 396
347 403
168 200
262 350
476 521
99 240
4 133
212 257
2 3
123 219
1 118
79 223
44 363
87 188
25 65
277 290
89 114"""
    
    # Parse coordinates
    coords = parse_coordinates(input_text)
    
    # Process and generate output
    results = process_coordinates(coords)
    
    # Print results
    for result in results:
        print(result)

if __name__ == "__main__":
    main()
